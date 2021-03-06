/*
 * Copyright 2014 preciosjustosuda.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uda.preciosjustos.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.uda.preciosjustos.dao.ProductDao;
import org.uda.preciosjustos.model.Product;

/**
 *
 * @author octa
 */
@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product, Long> implements ProductDao{

    public ProductDaoImpl() {
        super(Product.class);
    }

	@Override
	public Product findByName(String name) {
		
		List<Product> products = listByCriteria(Restrictions.eq("name", name));
		
		if(products.size() > 0){
			return products.get(0);
		}else{
			return null;
		}
	}
    
}
