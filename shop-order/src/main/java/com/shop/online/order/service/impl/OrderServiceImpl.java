package com.shop.online.order.service.impl;

import com.shop.online.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.shop.online.order.entity.Order;
import com.shop.online.order.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Page<Order> queryByPageable(Integer page, Integer size, Boolean desc, String key) {
		Pageable pageable = new PageRequest(page, size, desc ? Direction.DESC : Direction.ASC, key);
		return orderRepository.findAll(pageable);
	}
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
