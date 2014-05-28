package org.uda.preciosjustos.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.uda.preciosjustos.model.Product;

public class ProductSearcher {

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
