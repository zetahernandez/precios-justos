package org.uda.preciosjustos.configuration;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


public class ConfigurableApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext applicationContext) {

		String profile = System.getProperty("profile");

		if (profile == null || profile.equalsIgnoreCase(Profile.DEV.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.DEV.name().toLowerCase());
		} else if (profile.equalsIgnoreCase(Profile.PRODUCTION.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.PRODUCTION.name().toLowerCase());
		} else if (profile.equalsIgnoreCase(Profile.TEST.name())) {
			applicationContext.getEnvironment().setActiveProfiles(Profile.TEST.name().toLowerCase());
		}
	}

}
