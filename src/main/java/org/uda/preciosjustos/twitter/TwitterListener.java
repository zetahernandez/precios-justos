package org.uda.preciosjustos.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.uda.preciosjustos.services.TwitterService;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Escuchador para mensajes de twitter
 * @author zeta
 *
 */
@Component
@Order(value=Ordered.LOWEST_PRECEDENCE)
public class TwitterListener implements StatusListener {

	private static final Logger LOG = LoggerFactory.getLogger(TwitterListener.class); 
	
	@Autowired
	private TwitterService twitterService;
	
	/* (non-Javadoc)
	 * @see twitter4j.StreamListener#onException(java.lang.Exception)
	 */
	@Override
	public void onException(Exception ex) {
		LOG.error("onException ex: " + ex.toString(), ex);
	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onStatus(twitter4j.Status)
	 */
	@Override
	public void onStatus(Status status) {
		LOG.debug("onStatus status: " + status.toString());
		twitterService.processTwitterStatus(status);

	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onDeletionNotice(twitter4j.StatusDeletionNotice)
	 */
	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		LOG.debug("onDeletionNotice statusDeletionNotice: " + statusDeletionNotice.toString());

	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onTrackLimitationNotice(int)
	 */
	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		LOG.debug("onTrackLimitationNotice numberOfLimitedStatuses: " + numberOfLimitedStatuses);
	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onScrubGeo(long, long)
	 */
	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		LOG.debug("onScrubGeo userId: " + userId + " upToStatusId: " + upToStatusId);

	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onStallWarning(twitter4j.StallWarning)
	 */
	@Override
	public void onStallWarning(StallWarning warning) {
		LOG.debug("onStallWarning warning: " + warning.toString());
	}
}
