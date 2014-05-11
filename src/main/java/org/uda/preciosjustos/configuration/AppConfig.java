/**
 * 
 */
package org.uda.preciosjustos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.uda.preciosjustos.task.HerokuNotIdle;

/**
 * see <a href=
 * "http://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/context/annotation/Configuration.html"
 * >Configuration</a>
 * 
 * @author zeta
 * 
 */

@Configuration
@ComponentScan("org.uda.preciosjustos")
@Import(PersistenceConfig.class)
@EnableScheduling
public class AppConfig {
	
	@Bean
	public HerokuNotIdle herokuNotIdle(){
		return new HerokuNotIdle();
	}
	
}

