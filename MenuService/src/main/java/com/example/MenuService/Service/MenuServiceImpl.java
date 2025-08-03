package com.example.MenuService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MenuService.Dto.MenuItemDTO;
import com.example.MenuService.Entity.MenuItem;
import com.example.MenuService.Repository.MenuRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public MenuItemDTO addMenuItem(MenuItemDTO dto) {
        MenuItem item = new MenuItem(dto.getName(), dto.getPrice());
        MenuItem saved = repository.save(item);
        //this is for push
        return new MenuItemDTO(saved.getId(), saved.getName(), saved.getPrice());
    }

    @Override
    public MenuItemDTO getMenuItemById(Long id) {
        MenuItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        return new MenuItemDTO(item.getId(), item.getName(), item.getPrice());
    }

    @Override
    public List<MenuItemDTO> getAllMenuItems() {
        return repository.findAll().stream()
                .map(item -> new MenuItemDTO(item.getId(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());
    }
}

