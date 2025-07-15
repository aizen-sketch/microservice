package com.example.MenuService.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.MenuService.Dto.MenuItemDTO;

@Service
public class MenuProducer {
	private final KafkaTemplate<String, MenuItemDTO> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public MenuProducer(KafkaTemplate<String, MenuItemDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMenuData(MenuItemDTO menu) {
        kafkaTemplate.send(topicName, menu);
    }
}


