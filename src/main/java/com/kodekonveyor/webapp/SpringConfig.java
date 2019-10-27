package com.kodekonveyor.webapp;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootConfiguration
@ComponentScan({ "com.kodekonveyor" })
@EnableAutoConfiguration
@EntityScan("com.kodekonveyor")
@EnableJpaRepositories("com.kodekonveyor")
@EnableWebMvc
@EnableTransactionManagement
@InterfaceClass
@ExcludeFromCodeCoverage("Configuration")
public class SpringConfig implements WebMvcConfigurer {

	@Value("${com.kodekonveyor.tidyup.jdbcUri}")
	private String jdbcUri;

	@Value("${com.kodekonveyor.tidyup.jdbcDriver}")
	private String jdbcDriver;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public DataSource dataSource() {
		final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(jdbcDriver);
		dataSourceBuilder.url(jdbcUri);
		return dataSourceBuilder.build();
	}

}
