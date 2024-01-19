package com.derster.sentiment.analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class SentimentAnalysisApplication {

	public static void main(String[] args) {
		var app =  new SpringApplication(SentimentAnalysisApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));

		var run = app.run(args);
		MyFirstService myFirstService = run.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOsName());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomProp2());
		System.out.println(myFirstService.getDataFromProp());
	}

}
