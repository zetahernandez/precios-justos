/**
 * 
 */
package org.uda.preciosjustos.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * see <a href=
 * "http://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/context/annotation/Configuration.html"
 * >Configuration</a>
 * 
 * @author zeta
 * 
 */
@EnableWebMvc
@Configuration
@ComponentScan("org.uda.preciosjustos")
@Import(PersistenceConfig.class)
public class AppConfig {
	
	@Bean
    public ContentNegotiatingViewResolver viewResolver() {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
		
		InternalResourceViewResolver internalViewResolver = new InternalResourceViewResolver();
		internalViewResolver.setPrefix("/WEB-INF/jsp/");
		internalViewResolver.setSuffix(".jsp");
		
		viewResolvers.add(internalViewResolver);
		
		resolver.setViewResolvers(viewResolvers );
		
        return resolver;
    }
}

