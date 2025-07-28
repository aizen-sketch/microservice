package com.example.MenuService.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MenuService.Dto.MenuItemDTO;
import com.example.MenuService.repo.MenuRepository;

@RestController
@RequestMapping("/menuitems")
public class menuController {
	
	@Autowired
	private MenuRepository menurepo;
	@GetMapping
    public List<MenuItemDTO> getAll() {
		return menurepo.findAll().stream()
                .map(item -> new MenuItemDTO(item.getId(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());
    }
	@GetMapping("/menuHealth")
    public String getHealth() {
		return "MenuService-1";
    }

}
