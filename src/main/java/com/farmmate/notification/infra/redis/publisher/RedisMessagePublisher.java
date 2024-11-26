package com.farmmate.notification.infra.redis.publisher;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisMessagePublisher {

	private final RedisTemplate<String, Object> redisTemplate;

	public void publish(String channel, String message) {
		redisTemplate.convertAndSend(channel, message);
		log.info("Message sent to channel: {}", channel);
	}
}
