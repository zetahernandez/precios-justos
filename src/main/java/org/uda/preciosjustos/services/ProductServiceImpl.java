package org.uda.preciosjustos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.uda.preciosjustos.dao.ProductDao;
import org.uda.preciosjustos.model.Product;

/**
 * @author zeta
 *
 */
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Product> allProducts() {
		return productDao.listAll();
	}

}
