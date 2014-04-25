/**
 * 
 */
package org.uda.preciosjustos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uda.preciosjustos.dto.HelloDTO;

/**
 * @author zeta
 *
 */
@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping(method=RequestMethod.GET)
	
	public @ResponseBody HelloDTO getController(){
		HelloDTO helloDTO = new HelloDTO();
		helloDTO.setMessage("hola");
		return helloDTO;
	}
}
