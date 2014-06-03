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

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.uda.preciosjustos.dao.InputDao;
import org.uda.preciosjustos.model.Input;

/**
 *
 * @author octa
 */
@Repository
public class InputDaoImpl extends AbstractDaoImpl<Input, Long> implements InputDao{

    public InputDaoImpl() {
        super(Input.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Input> findByProductName(String productName) {
		Query createQuery = getCurrentSession().createQuery("Select i From Input as i join i.product as p where p.name = :productName");
		createQuery.setParameter("productName", productName);
		return (List<Input>) createQuery.list();
	}
    
}
