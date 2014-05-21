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


import org.springframework.stereotype.Repository;
import org.uda.preciosjustos.dao.TwitterUserDao;
import org.uda.preciosjustos.model.TwitterUser;

/**
 *
 * @author octa
 */
@Repository
public class TwitterUserDaoImpl extends AbstractDaoImpl<TwitterUser, Long> implements TwitterUserDao{

    public TwitterUserDaoImpl() {
        super(TwitterUser.class);
    }
    
}
