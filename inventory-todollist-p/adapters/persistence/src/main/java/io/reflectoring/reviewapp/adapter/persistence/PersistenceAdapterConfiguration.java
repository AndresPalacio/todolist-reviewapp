package io.reflectoring.reviewapp.adapter.persistence;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mongodb.Mongo;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

@Configuration
@EnableJdbcRepositories
@ComponentScan
class PersistenceAdapterConfiguration extends JdbcConfiguration {

	@Bean
	NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	 @Bean
	    public Mongo mongo() throws IOException {
	        System.setProperty("DB.TRACE","true");
	        return new EmbeddedMongoBuilder() 
	            .version("2.13.1")
	            .bindIp("127.0.0.1")
	            .port(1234)
	            .build();
	    }

}
