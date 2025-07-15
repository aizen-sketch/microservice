package com.example.MenuService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.MenuService.Dto.MenuItemDTO;
import com.example.MenuService.Entity.MenuEntity;
import com.example.MenuService.repo.MenuRepository;

@Service
public class MenuConsumer {
	@Autowired
    private final MenuRepository menuRepository;

    public MenuConsumer(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "menu-service-1")
    public void consume(MenuItemDTO menu) {
        // Convert to entity and save
        MenuEntity entity = new MenuEntity(menu.getId(), menu.getName(), menu.getPrice());
        menuRepository.save(entity);
    }
}
