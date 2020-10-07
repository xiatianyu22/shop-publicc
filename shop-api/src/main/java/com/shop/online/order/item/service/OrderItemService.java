package com.shop.online.order.item.service;

import java.util.List;

import com.shop.online.order.item.entity.OrderItem;


public interface OrderItemService {
	
	public List<OrderItem> queryByOrderId(Long orderId);
	
	public OrderItem saveOrderItem(OrderItem orderItem);
}
