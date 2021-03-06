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

import javax.persistence.CascadeType;
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
public class Input implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 3726557978703807755L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;
    
    @Column (nullable = false)
    private float quantity;
    
    @Column (nullable = false)
    private float price;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Position position;
    
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created_at;
    
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Tweet tweet;

    public Input() {
    }

    public Input(Product product, float quantity, float price, Position position, Date created_at, Tweet tweet) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.position = position;
        this.created_at = created_at;
        this.tweet = tweet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getCantity() {
        return quantity;
    }

    public void setCantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
    
    
    
}
