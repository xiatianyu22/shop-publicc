package com.shop.online.order.item.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.online.order.item.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	List<OrderItem> findAllByOrderId(Long orderId);

}
