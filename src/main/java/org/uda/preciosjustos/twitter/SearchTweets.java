package org.uda.preciosjustos.twitter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Component
public class SearchTweets{

	private TwitterStream twitterStream;
	
	@Autowired
	private TwitterListener twitterListener;
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(twitterListener);
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
	    FilterQuery filterQuery = new FilterQuery();
	    filterQuery.track(new String[] {"preciosjustos"});
	    twitterStream.filter(filterQuery);
	}
	
	
	public void changeTracker(String[] tracks){
		twitterStream.cleanUp();
		FilterQuery filterQuery = new FilterQuery();
	    filterQuery.track(tracks);
	    twitterStream.filter(filterQuery);  
	}
	
	public void stopTrack(){
		twitterStream.shutdown();
	}
	
	

}
