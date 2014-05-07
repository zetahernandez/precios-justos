package org.uda.preciosjustos.services;

import twitter4j.Status;

public interface TwitterService {

	void processTwitterStatus(Status status);  
}
