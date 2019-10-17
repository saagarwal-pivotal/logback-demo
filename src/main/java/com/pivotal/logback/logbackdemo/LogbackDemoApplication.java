package com.pivotal.logback.logbackdemo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.classic.LoggerContext;
import com.pivotal.logback.logbackdemo.component.TestComponent;
import com.pivotal.logback.logbackdemo.component.TestComponent2;

@SpringBootApplication
public class LogbackDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LogbackDemoApplication.class, args);
		TestComponent testCom = context.getBean(TestComponent.class);
		testCom.processStep();

		TestComponent2 testCom2 = context.getBean(TestComponent2.class);
		testCom2.processStep();

		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		loggerContext.stop();
	}

}
