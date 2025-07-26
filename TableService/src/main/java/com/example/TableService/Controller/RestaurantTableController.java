package com.example.TableService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.TableService.Dto.RestaurantTableDTO;
import com.example.TableService.Service.RestaurantTableService;

import java.util.List;

@RestController
@RequestMapping("/")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService tableService;

    @PostMapping("/tables")
    public RestaurantTableDTO addTable(@RequestBody RestaurantTableDTO dto) {
        return tableService.addTable(dto);
    }

    @GetMapping("/tables/{id}")
    public RestaurantTableDTO getTableById(@PathVariable Long id) {
        return tableService.getTableById(id);
    }

    @GetMapping("/tables")
    public List<RestaurantTableDTO> getAllTables() {
        return tableService.getAllTables();
    }
}

