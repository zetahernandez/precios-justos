package org.uda.preciosjustos.dto;

import java.io.Serializable;

/**
 * @author zeta
 *
 */
public class PositionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2829899543673968971L;
	
	private Double latitude;
	private Double longitude;
	private String address;
	
	
	
	public PositionDTO() {
	}
	
	public PositionDTO(Double latitude, Double longitude, String address) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
