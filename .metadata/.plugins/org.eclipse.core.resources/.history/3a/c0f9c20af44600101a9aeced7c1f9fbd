package com.example.TableService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TableService.Dto.RestaurantTableDTO;
import com.example.TableService.Entity.RestaurantTable;
import com.example.TableService.Repository.RestaurantTableRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    private RestaurantTableRepository repository;

    @Override
    public RestaurantTableDTO addTable(RestaurantTableDTO dto) {
        RestaurantTable table = new RestaurantTable();
        table.setTableNumber(dto.getTableNumber());
        table.setCapacity(dto.getCapacity());

        RestaurantTable saved = repository.save(table);
        return convertToDTO(saved);
    }

    @Override
    public RestaurantTableDTO getTableById(Long id) {
        RestaurantTable table = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        return convertToDTO(table);
    }

    @Override
    public List<RestaurantTableDTO> getAllTables() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RestaurantTableDTO convertToDTO(RestaurantTable table) {
        return new RestaurantTableDTO(table.getId(), table.getTableNumber(), table.getCapacity());
    }
}

