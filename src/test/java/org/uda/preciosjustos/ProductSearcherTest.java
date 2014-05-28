package org.uda.preciosjustos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.uda.preciosjustos.model.Product;
import org.uda.preciosjustos.model.Unit;
import org.uda.preciosjustos.services.AddressSearcher;
import org.uda.preciosjustos.services.PriceSearcher;
import org.uda.preciosjustos.services.ProductSearcher;
import org.uda.preciosjustos.services.TweetData;
import org.uda.preciosjustos.services.TweetExtractor;

public class ProductSearcherTest extends RepositoryTestBase {

	@Test
	public void testProductSearcher() throws Exception{
		
		List<Product> products = new ArrayList<Product>();
		Product product = new Product("manzana",null);
		Product product2 = new Product("pera",null);
		products.add(product2);
		products.add(product);
		String tweetText = "Compre el kilo de manzana a $ 15 pesos";
		Product search = new ProductSearcher().search(tweetText , products);
		
		Assert.assertEquals(product, search);
	}
	
	@Test
	public void testPriceSearcher() throws Exception {
		String tweetText = "Compre el kilo de manzana a $ 15  $18 $18,50 $ 14,45 25 pesos";
		
		Float search = new PriceSearcher().search(tweetText);
		
		Assert.assertEquals(search, Float.valueOf(15f));
		
		tweetText = "Compre el kilo de manzana a  $18,50 $ 14,45 25 pesos";
		
		search = new PriceSearcher().search(tweetText);
		
		Assert.assertEquals(search, Float.valueOf(18.50f));
	}
	

	@Test
	public void testAddressSearcher() throws Exception {
		String tweetText = "Compre el kilo de manzana a $ 15 pesos en San Martin 185, Mendoza";
		
		String address = new AddressSearcher().search(tweetText);
		
		Assert.assertEquals(address, "San Martin 185, Mendoza");

	}
	
	@Test
	public void testTweeterExtractor() throws Exception{
		
		List<Product> products = new ArrayList<Product>();
		Unit unit = new Unit("Kilo");
		Product product = new Product("manzana",unit);
		Product product2 = new Product("pera",unit);
		products.add(product2);
		products.add(product);
		String tweetText = "Compre el kilo de manzana a $ 15 pesos en San Martin 185, Mendoza";
		TweetData extract = new TweetExtractor(products).extract(tweetText );
		
		
		Assert.assertEquals(product, extract.getProduct());
		Assert.assertEquals(unit, extract.getUnit());
		Assert.assertEquals(Float.valueOf(15f), extract.getPrice());
		Assert.assertEquals("San Martin 185, Mendoza",extract.getAddress());
	}
}
