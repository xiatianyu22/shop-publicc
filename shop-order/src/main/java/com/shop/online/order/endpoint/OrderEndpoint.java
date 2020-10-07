package com.shop.online.order.endpoint;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.order.entity.Order;
import com.shop.online.order.list.ListOrderRequestBody;
import com.shop.online.order.save.SaveOrderRequestBody;

@RestController
@RequestMapping(path="/order")
public class OrderEndpoint {
	
	@PostMapping("/save")
	public Response<Order> saveOrder(@RequestBody Request<SaveOrderRequestBody> req) {
		return null;
	}
	
	@PostMapping("/list")
	public Response<List<Order>> listOrder(@RequestBody Request<ListOrderRequestBody> req){
		return null;
	}

}
