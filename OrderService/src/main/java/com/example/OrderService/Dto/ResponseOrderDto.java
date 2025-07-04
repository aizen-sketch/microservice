package com.example.OrderService.Dto;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseOrderDto {
	private Long id;
    private Long tableId;
    private List<MenuItemDTO> menuItems;
    private String status;
    private Double totalBillAmount;
    private LocalDateTime orderTime;
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
	public List<MenuItemDTO> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItemDTO> menuItems) {
		this.menuItems = menuItems;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getTotalBillAmount() {
		return totalBillAmount;
	}
	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public ResponseOrderDto(Long id, Long tableId, List<MenuItemDTO> menuItems, String status, Double totalBillAmount,
			LocalDateTime orderTime) {
		super();
		this.id = id;
		this.tableId = tableId;
		this.menuItems = menuItems;
		this.status = status;
		this.totalBillAmount = totalBillAmount;
		this.orderTime = orderTime;
	}
	public ResponseOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseDto [id=" + id + ", tableId=" + tableId + ", menuItems=" + menuItems + ", status=" + status
				+ ", totalBillAmount=" + totalBillAmount + ", orderTime=" + orderTime + "]";
	}
    
    
}
