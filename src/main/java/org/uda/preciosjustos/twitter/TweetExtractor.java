package org.uda.preciosjustos.services;

import java.util.List;

import org.uda.preciosjustos.model.Product;
import org.uda.preciosjustos.model.Unit;

public class TweetExtractor {

	private List<Product> products;

	public TweetExtractor(List<Product> products) {
		this.products = products;
	}

	public TweetData extract(String tweetText) throws Exception {
		TweetData tweetData = new TweetData();
		
		Product product = new ProductSearcher().search(tweetText, products);
		 
		Unit unit = new UnitSearcher().search(tweetText, product.getUnit());
		
		Float price = new PriceSearcher().search(tweetText);
		
		String address = new AddressSearcher().search(tweetText);
		
		//     \$( )*\d+(\,\d{2}){0,1}\b   $ 645    $6   $6,45
		
		tweetData.setAddress(address);
		tweetData.setPrice(price);
		tweetData.setProduct(product);
		tweetData.setUnit(unit);
		return tweetData;
	}

}
