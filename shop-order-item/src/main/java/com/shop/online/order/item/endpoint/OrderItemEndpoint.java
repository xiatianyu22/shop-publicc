package com.shop.online.order.item.endpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.order.item.entity.OrderItem;

@RestController
@RequestMapping(path="/order/item")
public class OrderItemEndpoint {
	
	@PostMapping("save")
	public Response<OrderItem> save(@RequestBody  Request<OrderItem> request) {
		return null;
	}
	
	@PostMapping("list")
	public Response<OrderItem> list(@RequestBody  Request<Long> request) {
		return null;
	}
}
