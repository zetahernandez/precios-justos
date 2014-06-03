package org.uda.preciosjustos.dto;

import java.io.Serializable;

/**
 * {
    "id": 1,
    "product": {
      "id": 1,
      "name": "tomate",
      "unit": "KILO"
    },
    "price": 12.44,
    "position": {
      "latitude": 68.548,
      "longitude": 38.548,
      "address": "San juan 188, Mendoza, Argentina"
    }

 * @author zeta
 *
 */
public class SearchDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668774527188438988L;
	
	private Long id;
	private ProductDTO product;
	private Float price;
	private PositionDTO position;
	
	public SearchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchDTO(Long id, ProductDTO product, Float price,
			PositionDTO position) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
	}
	
	
	
	
	

}
