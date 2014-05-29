package org.uda.preciosjustos.twitter;

import org.apache.commons.lang3.StringUtils;

/**
 * Responsable de obtener la cadena de direeción en un tweet
 * @author zeta
 * @author octa
 *
 */
public class AddressSearcher {

	/**
	 * Metodo que procesa un tweet y busca una dirección. El texto debe contener la secuencia "  en "
	 * y lo que sigue a continuación se interpreta como una dirección   
	 * 
	 * @param tweetText texto con el tweet
	 * @return una cadena que representa la dirección
	 * @throws Exception lanzada cuando no existe una dirección
	 */
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
