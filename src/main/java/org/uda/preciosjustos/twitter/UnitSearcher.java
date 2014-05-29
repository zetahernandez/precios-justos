package org.uda.preciosjustos.services;

import org.apache.commons.lang3.StringUtils;
import org.uda.preciosjustos.model.Unit;

public class UnitSearcher {

	public Unit search(String tweetText, Unit unit) throws Exception {
		String unitName = unit.getName();
		if(StringUtils.containsIgnoreCase(tweetText, unitName)){
			return unit;
		}
		
		throw new Exception("El tweet: " + tweetText + " no contiene la unidad " + unitName);
	}

}
