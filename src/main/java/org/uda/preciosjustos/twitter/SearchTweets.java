package org.uda.preciosjustos.twitter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 * Bean que cuando es instanciado por el framework, ejecuta el streaming de twitter
 * @author zeta
 *
 */
@Profile(value={"prod,dev"})
@Component
public class SearchTweets {

	private TwitterStream twitterStream;

	@Autowired
	private TwitterListener twitterListener;

	/**
	 * Método ejecutado luego de que se instancia la clase 
	 * @throws Exception
	 */
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.addListener(twitterListener);
		// sample() method internally creates a thread which manipulates
		// TwitterStream and calls these adequate listener methods continuously.
		FilterQuery filterQuery = new FilterQuery();
		filterQuery.track(new String[] { "preciosjustos" });
		twitterStream.filter(filterQuery);
	}

	/**
	 * Cambiar las palabaras a las que el escuchador responde
	 * @param tracks
	 */
	public void changeTracker(String[] tracks) {
		twitterStream.cleanUp();
		FilterQuery filterQuery = new FilterQuery();
		filterQuery.track(tracks);
		twitterStream.filter(filterQuery);
	}

	/**
	 * Finalizar el escuchador de mensajes de twitter
	 */
	public void stopTrack() {
		twitterStream.shutdown();
	}

}
