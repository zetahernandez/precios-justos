/**
 * 
 */
package org.uda.preciosjustos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.uda.preciosjustos.dto.HelloDTO;

/**
 * @author zeta
 *
 */
@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody HelloDTO getController(){
		HelloDTO helloDTO = new HelloDTO();
		helloDTO.setMessage("hola");
		return helloDTO;
	}
}
