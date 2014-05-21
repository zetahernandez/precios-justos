package org.uda.preciosjustos.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

/**
 * Bean utilizado para que heroku no se suspenda despues de 1 hora de inactividad
 * 
 * @author zeta
 *
 */
public class HerokuNotIdle {

	private static final Logger LOG = LoggerFactory.getLogger(HerokuNotIdle.class);
	
	/**
	 * Ejecuta un request a http://precios-justos.herokuapp.com/rest/ cada 2 minutos
	 */
	@Scheduled(fixedDelay=120000)
	public void herokuNotIdle(){
		LOG.debug("Heroku not idle execution");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://precios-justos.herokuapp.com/rest/", Object.class);
	}
}
