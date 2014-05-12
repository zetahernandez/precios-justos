package org.uda.preciosjustos.geocode;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderStatus;

public class AdressSearchTest {

	@Test
	public void test() throws IOException {
		String string = new String();
		
		AdressSearch adressSearch = new AdressSearch();
		GeocodeResponse response = adressSearch.searchAddress("Matheu 1905, Godoy Cruz, Mendoza", "AR");
		Assert.assertEquals(GeocoderStatus.OK, response.getStatus());
	}

}
