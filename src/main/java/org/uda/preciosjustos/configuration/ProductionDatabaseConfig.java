package org.uda.preciosjustos.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Configuración de acceso a datos para producción
 * 
 * @author zeta
 * 
 */
@Profile("prod")
@Configuration
@PropertySource("classpath:prod.properties")
public class ProductionDatabaseConfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() throws NamingException, URISyntaxException {
		String dburl = System.getenv("DATABASE_URL");
		URI uri = new URI(dburl);
		String[] userInfo = uri.getUserInfo().split(":");
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("jdbc:");
		urlBuilder.append(env.getProperty("jdbc.databaseType"));
		urlBuilder.append("://");
		urlBuilder.append(uri.getHost());
		urlBuilder.append(":");
		urlBuilder.append(uri.getPort());
		urlBuilder.append(uri.getPath());
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(urlBuilder.toString());
		dataSource.setUsername(userInfo[0]);
		dataSource.setPassword(userInfo[1]);
		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = -1315739295711577049L;

			{
				setProperty("hibernate.hbm2ddl.auto",
						env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect",
						env.getProperty("hibernate.dialect"));
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}
}
