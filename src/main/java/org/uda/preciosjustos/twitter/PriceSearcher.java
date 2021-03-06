package org.uda.preciosjustos.twitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Responsable de buscar el precio de un producto en un tweet
 * 
 * @author zeta
 * @author octa
 *
 */
public class PriceSearcher {

	/**
	 * Realiza la busqueda de el precio de un producto en el tweet los formatos válidos son
	 * $ 600; $12,23 ; $12 ; $ 1276,54  
	 * @param tweetText
	 * @return el precio en formato número
	 * @throws Exception
	 */
	public Float search(String tweetText) throws Exception {
		Pattern pattern = Pattern.compile("\\$( )*\\d+(\\,\\d{2}){0,1}\\b");
		Matcher matcher = pattern.matcher(tweetText);
		
		
		Float valueOfPrice = null;
		while (matcher.find() && valueOfPrice == null) {
			String price = StringUtils.replace(matcher.group(), "$", "");
			price = StringUtils.trim(price);
			price = StringUtils.replace(price, ",", ".");
		    valueOfPrice = Float.valueOf(price);
		}

		if(valueOfPrice == null){
			throw new Exception("No se encontro el precio con un formato valido");
		}
		return valueOfPrice;
	}

}
