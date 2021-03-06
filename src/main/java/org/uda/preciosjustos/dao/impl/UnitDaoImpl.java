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
import org.uda.preciosjustos.dao.UnitDao;
import org.uda.preciosjustos.model.Unit;

/**
 *
 * @author octa
 */
@Repository
public class UnitDaoImpl extends AbstractDaoImpl<Unit, Long> implements UnitDao{

    public UnitDaoImpl() {
        super(Unit.class);
    }

	@Override
	public Unit findByName(String name) {
		
		List<Unit> units = listByCriteria(Restrictions.eq("name", name));
		
		if(units.size() > 0){
			return units.get(0);
		}else{
			return null;
		}
	}
    
}
