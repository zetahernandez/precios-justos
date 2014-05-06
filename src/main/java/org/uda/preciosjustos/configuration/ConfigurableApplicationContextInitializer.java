package org.uda.preciosjustos.configuration;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Inicializador del contexto
 * @author zeta
 *
 */
public class ConfigurableApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext applicationContext) {

		String profile = System.getenv("profile");

		if (profile == null || profile.equalsIgnoreCase(Profile.DEV.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.DEV.name().toLowerCase());
		} else if (profile.equalsIgnoreCase(Profile.PROD.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.PROD.name().toLowerCase());
		} else if (profile.equalsIgnoreCase(Profile.TEST.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.TEST.name().toLowerCase());
		}
	}

}
