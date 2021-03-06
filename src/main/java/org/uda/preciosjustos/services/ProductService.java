package org.uda.preciosjustos.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.uda.preciosjustos.model.Product;

/**
 * @author zeta
 *
 */
@Transactional
public interface ProductService {

	/**
	 * Obtener todos los productos
	 * 
	 * @return List
	 */
	List<Product> allProducts();
}
