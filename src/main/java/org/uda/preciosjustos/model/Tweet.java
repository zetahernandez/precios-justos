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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author octa
 */
@Entity
public class Tweet implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4855104408061127817L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (nullable = false)
    private Long id;
    
    @Column (nullable = false)
    private Long tweet_id;
    
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created_at;
    
    @Column (nullable = false)
    private String text;
    
    @ManyToOne
    private TwitterUser user;
    
    @Column (nullable = false)
    private String tweet_json;

    public Tweet() {
    }

    public Tweet(Long tweet_id, Date created_at, String text, TwitterUser user, String tweet_json) {
        this.tweet_id = tweet_id;
        this.created_at = created_at;
        this.text = text;
        this.user = user;
        this.tweet_json = tweet_json;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTweet_id() {
        return tweet_id;
    }

    public void setTweet_id(Long tweet_id) {
        this.tweet_id = tweet_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TwitterUser getUser() {
        return user;
    }

    public void setUser(TwitterUser user) {
        this.user = user;
    }

    public String getTweet_json() {
        return tweet_json;
    }

    public void setTweet_json(String tweet_json) {
        this.tweet_json = tweet_json;
    }
    
    
    
}
