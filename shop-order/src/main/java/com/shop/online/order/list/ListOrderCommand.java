package com.shop.online.order.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.shop.online.core.BaseCommand;
import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.order.entity.Order;
import com.shop.online.order.service.OrderService;

@Component("order.list")
public class ListOrderCommand extends BaseCommand<List<Order>, ListOrderRequestBody> {
	
	@Autowired
	private OrderService orderService;


	@Override
	public Response<List<Order>> execute(Request<ListOrderRequestBody> request) {
		Page<Order> page = orderService.queryByPageable(request.getBody().getPage(), request.getBody().getSize(), request.getBody().getDesc(), request.getBody().getKey());
		return this.buildResponse(request.getMeta(), page.getContent());
	}

}
