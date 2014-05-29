package org.uda.preciosjustos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uda.preciosjustos.dao.ProductDao;
import org.uda.preciosjustos.model.Product;

/**
 * @author zeta
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	/* (non-Javadoc)
	 * @see org.uda.preciosjustos.services.ProductService#allProducts()
	 */
	@Override
	public List<Product> allProducts() {
		return productDao.listAll();
	}

}
