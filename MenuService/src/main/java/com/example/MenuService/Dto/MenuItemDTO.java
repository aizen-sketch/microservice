package com.example.MenuService.Dto;

public class MenuItemDTO {
    private Long id;
    private String name;
    private double price;

    // Constructors
    public MenuItemDTO() {}
    public MenuItemDTO(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

