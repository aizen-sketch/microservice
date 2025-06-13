package com.example.TableService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TableService.Entity.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
}

