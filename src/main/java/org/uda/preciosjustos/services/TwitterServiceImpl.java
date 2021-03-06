package org.uda.preciosjustos.services;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uda.preciosjustos.dao.InputDao;
import org.uda.preciosjustos.dao.ProductDao;
import org.uda.preciosjustos.geocode.AdressSearch;
import org.uda.preciosjustos.model.Input;
import org.uda.preciosjustos.model.Position;
import org.uda.preciosjustos.model.Product;
import org.uda.preciosjustos.model.Tweet;
import org.uda.preciosjustos.model.TwitterUser;
import org.uda.preciosjustos.twitter.TweetExtractor;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;

import twitter4j.Status;
import twitter4j.User;

@Service
public class TwitterServiceImpl implements TwitterService {

	private static final Logger LOG = LoggerFactory.getLogger(TwitterServiceImpl.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private InputDao inputDao;
	
	@Autowired
	private AdressSearch adressSearch; 
	
	@Override
	@Transactional
	public void processTwitterStatus(Status status) {
		String tweetText = status.getText();
		
		List<Product> products = productDao.listAll();
		TweetData tweetData = null;

		try{
			tweetData = new TweetExtractor(products).extract(tweetText);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
		if(tweetData!= null){
			GeocodeResponse geocodeResponse = null;
			try {
			
				geocodeResponse = adressSearch.searchAddress(tweetData.getAddress(), "AR");
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
			if(geocodeResponse != null && geocodeResponse.getStatus().equals(GeocoderStatus.OK)){
				Input input = new Input();
				input.setProduct(tweetData.getProduct());
				input.setCreated_at(GregorianCalendar.getInstance().getTime());
				input.setPrice(tweetData.getPrice().floatValue());
				input.setPosition(convertResponseToPosition(geocodeResponse));
				input.setTweet(convertToTweet(status)); //TODO: convert status to tweet
				inputDao.saveOrUpdate(input);	
			}
			
		}
		
	}

	private Tweet convertToTweet(Status status) {
		Tweet tweet = new Tweet();
		tweet.setCreated_at(status.getCreatedAt());
		tweet.setText(status.getText());
		tweet.setTweet_id(status.getId());
		tweet.setUser(convertToTweetUser(status.getUser()));
		//tweet.setTweet_json(convertToJson(status));
		return tweet;
	}

	private TwitterUser convertToTweetUser(User user) {
		TwitterUser twitterUser = new TwitterUser();
		twitterUser.setTwitter_user_id(user.getId());
		twitterUser.setName(user.getName());
		twitterUser.setProfile_image_url(user.getProfileImageURL());
		return twitterUser;
	}

	private Position convertResponseToPosition(GeocodeResponse geocodeResponse) {
		
		GeocoderResult geocoderResult = geocodeResponse.getResults().get(0);
		String address = geocoderResult.getFormattedAddress();
		Double latitude = Double.valueOf(geocoderResult.getGeometry().getLocation().getLat().doubleValue());
		Double longitude = Double.valueOf(geocoderResult.getGeometry().getLocation().getLng().doubleValue());
		Position position = new Position(latitude, longitude, address);
		return position;
	}

}
