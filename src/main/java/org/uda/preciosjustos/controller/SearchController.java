package org.uda.preciosjustos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.uda.preciosjustos.dto.PositionDTO;
import org.uda.preciosjustos.dto.ProductDTO;
import org.uda.preciosjustos.dto.SearchDTO;
import org.uda.preciosjustos.model.Input;
import org.uda.preciosjustos.model.Position;
import org.uda.preciosjustos.services.InputService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private InputService inputService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public List<SearchDTO> search(@RequestParam("productName") String productName,
			@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude,
			@RequestParam("strategy") int strategy) {
		
		Position position = new Position(latitude, longitude, null);
		
		List<Input> closestInputs = inputService.closestInputs(productName,	position, 5);
		
		return convertToSearchDto(closestInputs);
	}

	private List<SearchDTO> convertToSearchDto(List<Input> closestInputs) {

		List<SearchDTO> arrayList = new ArrayList<SearchDTO>();
		for (Input input : closestInputs) {
			ProductDTO product = new ProductDTO(input.getProduct().getId(), input.getProduct().getName(), input.getProduct().getUnit().getName());
			PositionDTO position = new PositionDTO(input.getPosition().getLatitude(),input.getPosition().getLongitude(),input.getPosition().getAddress());
			SearchDTO searchDTO = new SearchDTO(input.getId(), product, Float.valueOf(input.getPrice()), position);	
			arrayList.add(searchDTO);
		}
		return arrayList;
	}
}
