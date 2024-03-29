package com.pivotal.logback.logbackdemo.component;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

	private static final Logger lOG = LoggerFactory.getLogger(TestComponent.class);
	public static int STEP_COUNT = 10;

	public void processStep() {
		Instant start = Instant.now();
	 
		lOG.info("*** TestComponent started ***");
		for (int i = 0; i < STEP_COUNT; i++) {

			lOG.info("  Process step {} started.", i);
			try {
				Thread.sleep(10);
				lOG.debug("  Process step {} detail debug message.", i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lOG.info("  Process step {} completed.", i);
		}
		Instant end = Instant.now();
		lOG.warn("*** TestComponent completed with {} ***" + Duration.between(start, end));

	}

}
