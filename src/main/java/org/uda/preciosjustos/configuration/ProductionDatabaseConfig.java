package org.uda.preciosjustos.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
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

	public DataSource dataSource() throws NamingException {
		String dburl = System.getProperty("DATABASE_URL");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(dburl);

		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		return new Properties() {
			/**
				 * 
				 */
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
