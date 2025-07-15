package com.example.MenuService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MenuService.Entity.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {}