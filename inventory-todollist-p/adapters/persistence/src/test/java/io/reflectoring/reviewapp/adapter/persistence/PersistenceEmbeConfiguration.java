package io.reflectoring.reviewapp.adapter.persistence;

import java.io.IOException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

@Configuration
@ComponentScan
public class PersistenceEmbeConfiguration {
	
	 
	    public Mongo mongo() throws IOException {
	        System.setProperty("DB.TRACE","true");
	        return new EmbeddedMongoBuilder() 
	            .version("2.13.1")
	            .bindIp("127.0.0.1")
	            .port(1234)
	            .build();
	    }

}
