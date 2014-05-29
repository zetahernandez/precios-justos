/**
 * 
 */
package org.uda.preciosjustos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.uda.preciosjustos.dto.HelloDTO;
import org.uda.preciosjustos.model.Input;
import org.uda.preciosjustos.services.InputService;
import org.uda.preciosjustos.services.ProductService;

/**
 * @author zeta
 * 
 */

@RestController
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private InputService inputService;
	
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public HelloDTO getController() {
		HelloDTO helloDTO = new HelloDTO();
		helloDTO.setMessage("hola");
		service.allProducts();
		return helloDTO;
	}
	
	@RequestMapping(value="inputs/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public List<Input> getInputs() {
		return inputService.allInputs();
	}
	
}
