package org.uda.preciosjustos.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.uda.preciosjustos.IntegrationTestBase;

public class HelloControllerTest extends IntegrationTestBase {

	@Test
	public void getHello() throws Exception {

		this.mvc.perform(get("/").accept("application/json")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message").value("hola"));
	}
	

}
