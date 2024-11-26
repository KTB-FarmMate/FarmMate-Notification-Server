package com.farmmate.notification.infra.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.farmmate.notification.crop.repository.CropRepository;
import com.farmmate.notification.infra.redis.listner.RedisMessageListener;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
	private final CropRepository cropRepository;

	@Bean
	public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
		MessageListenerAdapter listenerAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();

		container.setConnectionFactory(connectionFactory);
		cropRepository.findAll().forEach(crop -> {
			container.addMessageListener(listenerAdapter, new ChannelTopic(crop.getName()));
		});

		return container;
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(RedisMessageListener listener) {
		return new MessageListenerAdapter(listener);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		return template;
	}
}
