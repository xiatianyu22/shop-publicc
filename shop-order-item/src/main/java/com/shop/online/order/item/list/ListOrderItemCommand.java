package com.shop.online.order.item.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.online.core.BaseCommand;
import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.order.item.entity.OrderItem;
import com.shop.online.order.item.service.OrderItemService;

@Component("order.item.list")
public class ListOrderItemCommand extends BaseCommand<List<OrderItem>, Long> {
	@Autowired
	private OrderItemService orderItemService;

	@Override
	public Response<List<OrderItem>> execute(Request<Long> request) {
		List<OrderItem> list = orderItemService.queryByOrderId(request.getBody());
		return this.buildResponse(request.getMeta(), list);
	}

}
