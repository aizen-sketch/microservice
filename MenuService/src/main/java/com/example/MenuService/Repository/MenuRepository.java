package com.example.MenuService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.MenuService.Entity.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
}

