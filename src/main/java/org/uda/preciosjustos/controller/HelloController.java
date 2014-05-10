/**
 * 
 */
package org.uda.preciosjustos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.uda.preciosjustos.dto.HelloDTO;

/**
 * @author zeta
 *
 */

@RestController
@RequestMapping("/")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public HelloDTO getController(){
		HelloDTO helloDTO = new HelloDTO();
		helloDTO.setMessage("hola");
		return helloDTO;
	}
}
