package com.farmmate.notification.infra.redis.listner;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisMessageListener {
	private final ObjectMapper objectMapper;

	public void handleMessage(String message) {
		try {
			log.info("Received message: {}", message);
		} catch (Exception e) {
			log.error("Error occurred while processing message: {}", message, e);
		}
	}
}
