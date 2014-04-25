package org.uda.preciosjustos.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Inicializador del contexto
 * @author zeta
 *
 */
public class ConfigurableApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurableApplicationContextInitializer.class);
	
	public void initialize(ConfigurableApplicationContext applicationContext) {
		LOG.debug("initialize enveriment");
		String profile = System.getProperty("profile");
		LOG.debug("enviroment: " + profile);
		if (profile == null || profile.equalsIgnoreCase(Profile.DEV.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.DEV.name().toLowerCase());
		} else if (profile.equalsIgnoreCase(Profile.PRODUCTION.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.PRODUCTION.name().toLowerCase());
		} else if (profile.equalsIgnoreCase(Profile.TEST.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.TEST.name().toLowerCase());
		}
	}

}
