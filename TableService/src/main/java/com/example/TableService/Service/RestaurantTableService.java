package com.example.TableService.Service;

import java.util.List;
import com.example.TableService.Dto.RestaurantTableDTO;

public interface RestaurantTableService {
    RestaurantTableDTO addTable(RestaurantTableDTO dto);
    RestaurantTableDTO getTableById(Long id);
    List<RestaurantTableDTO> getAllTables();
}
