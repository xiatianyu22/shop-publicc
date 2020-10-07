package com.shop.online.order.service;

import org.springframework.data.domain.Page;

import com.shop.online.order.entity.Order;

public interface OrderService {
	
	Page<Order> queryByPageable(Integer page, Integer size, Boolean desc, String key);
	
	public Order saveOrder(Order order);
}
