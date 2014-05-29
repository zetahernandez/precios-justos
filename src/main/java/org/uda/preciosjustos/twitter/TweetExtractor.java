package org.uda.preciosjustos.twitter;

import java.util.List;

import org.uda.preciosjustos.model.Product;
import org.uda.preciosjustos.model.Unit;
import org.uda.preciosjustos.services.TweetData;

/**
 * Responsable de analizar un teweet y verficar su validez
 * en caso de ser válido extrae la información sensible para el sistema
 * 
 * @author zeta
 * @author octa
 *
 */
public class TweetExtractor {

	private List<Product> products;

	/**
	 * @param products lista de productos de referencia
	 */
	public TweetExtractor(List<Product> products) {
		this.products = products;
	}

	/**
	 * Analizador del texto del tweet para extraer la información sensible para el sistema,
	 * Extrae el producto, el precio, la unidad y la direccion que el tuit hace referencia
	 * 
	 * @param tweetText texto del tweet
	 * @return TweetData con la información obtenida
	 * 
	 * @throws Exception en caso de no ser un tuit válido
	 */
	public TweetData extract(String tweetText) throws Exception {
		TweetData tweetData = new TweetData();
		
		Product product = new ProductSearcher().search(tweetText, products);
		 
		Unit unit = new UnitSearcher().search(tweetText, product.getUnit());
		
		Float price = new PriceSearcher().search(tweetText);
		
		String address = new AddressSearcher().search(tweetText);
		
		tweetData.setAddress(address);
		tweetData.setPrice(price);
		tweetData.setProduct(product);
		tweetData.setUnit(unit);
		return tweetData;
	}

}
