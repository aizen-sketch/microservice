package com.example.OrderService.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tableId;

    @ElementCollection
    private List<Long> menuItemIds;

    private String status; // e.g., "PLACED", "COMPLETED"

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public List<Long> getMenuItemIds() {
		return menuItemIds;
	}

	public void setMenuItemIds(List<Long> menuItemIds) {
		this.menuItemIds = menuItemIds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderEntity(Long id, Long tableId, List<Long> menuItemIds, String status) {
		super();
		this.id = id;
		this.tableId = tableId;
		this.menuItemIds = menuItemIds;
		this.status = status;
	}

	public OrderEntity() {
		super();
	}

    // Getters and Setters
    
}
