package com.schram.simplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
    @PropertySource(value = "classpath:application.properties"),
    @PropertySource(value = "file:${TOMCAT_HOME}/conf/simplespringboot.properties", ignoreResourceNotFound = true)
})
@SpringBootApplication
public class SimpleSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootApplication.class, args);
	}
}