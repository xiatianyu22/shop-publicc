package com.shop.online.order.item.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.online.order.item.entity.OrderItem;
import com.shop.online.order.item.repositories.OrderItemRepository;
import com.shop.online.order.item.service.OrderItemService;


@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public List<OrderItem> queryByOrderId(Long orderId) {
		return orderItemRepository.findAllByOrderId(orderId);
	}
	
	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

}
