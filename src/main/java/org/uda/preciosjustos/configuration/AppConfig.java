/**
 * 
 */
package org.uda.preciosjustos.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
public class AppConfig {


}
