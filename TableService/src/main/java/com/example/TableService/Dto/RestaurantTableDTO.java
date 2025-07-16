package com.example.TableService.Dto;

import java.io.Serializable;

public class RestaurantTableDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;
    private int tableNumber;
    private int capacity;

    public RestaurantTableDTO() {}

    public RestaurantTableDTO(Long id, int tableNumber, int capacity) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
