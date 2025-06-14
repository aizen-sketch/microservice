package com.example.OrderService.Service;

import java.util.List;

import com.example.OrderService.Dto.OrderDTO;
import com.example.OrderService.Dto.ResponseOrderDto;

public interface OrderService {
	ResponseOrderDto createOrder(OrderDTO dto);
	public ResponseOrderDto findOrder(Long orderId);
    double getAmountForTable(Long tableId);
    double getAmountForOrder(Long orderId);
    List<OrderDTO> getAllOrders();
}
