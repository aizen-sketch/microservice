package com.example.OrderService.Dto;

import java.util.List;

public class OrderDTO {
    private Long id;
    private Long tableId;
    private List<Long> menuItemIds;
    private String status;
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
	public OrderDTO(Long id, Long tableId, List<Long> menuItemIds, String status) {
		super();
		this.id = id;
		this.tableId = tableId;
		this.menuItemIds = menuItemIds;
		this.status = status;
	}
	public OrderDTO() {
		super();
	}
    
}
