package com.example.MenuService.Service;

import java.util.List;

import com.example.MenuServiceDto.MenuItemDTO;

public interface MenuService {

    MenuItemDTO addMenuItem(MenuItemDTO dto);

    MenuItemDTO getMenuItemById(Long id);

    List<MenuItemDTO> getAllMenuItems();
}