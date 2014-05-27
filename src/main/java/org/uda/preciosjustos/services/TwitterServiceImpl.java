package org.uda.preciosjustos.services;

import java.util.StringTokenizer;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import twitter4j.Status;

@Service
public class TwitterServiceImpl implements TwitterService {

	private static final Logger LOG = LoggerFactory.getLogger(TwitterServiceImpl.class);
	
	
	
	@Override
	@Transactional
	public void processTwitterStatus(Status status) {
	}

}
