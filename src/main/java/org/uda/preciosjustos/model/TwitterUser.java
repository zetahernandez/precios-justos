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

package org.uda.preciosjustos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author octa
 */
@Entity
public class TwitterUser implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8870145476538416241L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private Long twitter_user_id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String profile_image_url;

    public TwitterUser() {
    }

    public TwitterUser(Long twitter_user_id, String name, String profile_image_url) {
        this.twitter_user_id = twitter_user_id;
        this.name = name;
        this.profile_image_url = profile_image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTwitter_user_id() {
        return twitter_user_id;
    }

    public void setTwitter_user_id(Long twitter_user_id) {
        this.twitter_user_id = twitter_user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }
    
    
    
}
