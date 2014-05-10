package org.uda.preciosjustos.geocode;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

@Component
public class AdressSearch {

	
	/**
	 * Proceso de transformar direcciones (como "1600 Amphitheatre Parkway, Mountain View, CA") en coordenadas geográficas (como 37.423021 de latitud y -122.083739 de longitud)
	 * 
	 * @param address  es la dirección que quieres codificar de forma geográfica. 
	 * @param region es el código de país, especificado como un valor de dos caracteres ccTLD ("dominio de nivel superior"). 
	 * Este parámetro solo afectará a los resultados del geocoder (aunque puede que no se limite exclusivamente a este elemento).
	 * (Para obtener más información, consulta la sección Cómo especificar la región que aparece a continuación).
	 * @return GeocodeResponse
	 * @throws IOException
	 */
	public GeocodeResponse searchAddress(String address,String region) throws IOException{
		
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setRegion(region).setLanguage("en").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		
		return geocoderResponse;
	}
}
