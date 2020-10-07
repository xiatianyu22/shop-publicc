package com.shop.online.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.order.item.entity.OrderItem;

@Component
@FeignClient(value = "shop-order-item")
public interface OrderItemFeignService {
	
	@PostMapping("/order/item/save")
	public Response<OrderItem> save(@RequestBody  Request<OrderItem> request) ;
	
}
