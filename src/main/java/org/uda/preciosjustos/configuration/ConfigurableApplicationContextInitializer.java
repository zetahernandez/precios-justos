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

		String profile = System.getenv("profile");
		
		LOG.debug("Read the enviroment variable profile with the value: " + profile);
		
		if (profile == null || profile.equalsIgnoreCase(Profile.DEV.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.DEV.name().toLowerCase());
			LOG.debug("Set the active profile as dev");
		} else if (profile.equalsIgnoreCase(Profile.PROD.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.PROD.name().toLowerCase());
			LOG.debug("Set the active profile as prod");
		} else if (profile.equalsIgnoreCase(Profile.TEST.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.TEST.name().toLowerCase());
			LOG.debug("Set the active profile as test");
		}
	}

}
