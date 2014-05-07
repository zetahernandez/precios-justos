package org.uda.preciosjustos.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uda.preciosjustos.services.TwitterService;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Component
public class TwitterListener implements StatusListener {

	private static final Logger LOG = LoggerFactory.getLogger(TwitterListener.class); 
	
	@Autowired
	private TwitterService twitterService;
	
	@Override
	public void onException(Exception ex) {
		LOG.error("onException ex: " + ex.toString(), ex);
	}

	@Override
	public void onStatus(Status status) {
		LOG.debug("onStatus status: " + status.toString());
		twitterService.processTwitterStatus(status);

	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		LOG.debug("onDeletionNotice statusDeletionNotice: " + statusDeletionNotice.toString());

	}

	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		LOG.debug("onTrackLimitationNotice numberOfLimitedStatuses: " + numberOfLimitedStatuses);
	}

	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		LOG.debug("onScrubGeo userId: " + userId + " upToStatusId: " + upToStatusId);

	}

	@Override
	public void onStallWarning(StallWarning warning) {
		LOG.debug("onStallWarning warning: " + warning.toString());
	}
}
