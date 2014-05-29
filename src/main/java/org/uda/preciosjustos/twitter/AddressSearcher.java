package org.uda.preciosjustos.services;

import org.apache.commons.lang3.StringUtils;

public class AddressSearcher {

	public String search(String tweetText) throws Exception {
		int indexOf = StringUtils.lastIndexOf(tweetText," en ");
		if(indexOf == -1){
			throw new Exception("No se encuentra la direccion");
		}
		//le sumo los 4 caracteres de " en "
		indexOf += 4;
		
		String address = StringUtils.substring(tweetText, indexOf);
		
		if(address.length() < 1){
			throw new Exception("No se encuentra la direccion");
		}
		
		
		return address;
	}

}
