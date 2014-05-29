package org.uda.preciosjustos.twitter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.uda.preciosjustos.model.Product;

/**
 * Responsable de buscar un producto en el texto de un tweet
 * 
 * @author zeta
 * @author zeta
 *
 */
public class ProductSearcher {

	/**
	 * Extrae a partir de una referencia de productos el producto que se encuentra en 
	 * el texto del tweet 
	 * 
	 * @param tweetText texto del tweet
	 * @param products productos de referencia
	 * @return el producto encontrado
	 * @throws Exception
	 */
	public Product search(String tweetText, List<Product> products) throws Exception {
		Product result = null;
		for (Product product : products) {
			String productName = product.getName();
			if(StringUtils.containsIgnoreCase(tweetText, productName)){
				result =  product;
			}			
		}
		if(result == null){
			throw new Exception("El tweet: " + tweetText + " No contiene un producto valido");
		}
		return result;
	}

}
