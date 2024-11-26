package com.farmmate.notification;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class NotificationApplicationTests {
	@Container
	static DockerComposeContainer<?> composeContainer =
		new DockerComposeContainer<>(new File("compose.yaml"))
			.withExposedService("mysql", 3306)
			.withExposedService("redis", 6379);

	@Test
	void contextLoads() {
	}

}
