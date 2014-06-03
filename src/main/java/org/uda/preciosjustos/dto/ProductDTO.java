/**
 * 
 */
package org.uda.preciosjustos.dto;

import java.io.Serializable;

/**
 * 
 * @author zeta
 *
 */
public class ProductDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8919985883342136289L;
	
	private Long id;
	private String name;
	private String unit;
	
	public ProductDTO() {
		super();
	}
	
	
	public ProductDTO(Long id, String name, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
