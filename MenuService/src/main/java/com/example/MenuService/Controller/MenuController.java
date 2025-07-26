package com.example.MenuService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MenuService.Dto.MenuItemDTO;
import com.example.MenuService.Service.MenuProducer;
import com.example.MenuService.Service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
	private final MenuProducer menuProducer;

    public MenuController(MenuProducer menuProducer) {
        this.menuProducer = menuProducer;
    }

    @Autowired
    private MenuService service;
    
    @PostMapping
    public ResponseEntity<String> addMenu(@RequestBody MenuItemDTO menu) {
        // Save to DB (optional)
    	service.addMenuItem(menu);
        menuProducer.sendMenuData(menu);
        return ResponseEntity.ok("Menu sent to Kafka");
    }

//    @PostMapping
//    public MenuItemDTO addMenuItem(@RequestBody MenuItemDTO dto) {
//        return service.addMenuItem(dto);
//    }

    @GetMapping("/{id}")
    public MenuItemDTO getById(@PathVariable Long id) {
        return service.getMenuItemById(id);
    }

    @GetMapping("/all")
    public List<MenuItemDTO> getAll() {
        return service.getAllMenuItems();
    }
}
