package com.shop.online.order.item.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.online.core.BaseCommand;
import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.order.item.entity.OrderItem;
import com.shop.online.order.item.service.OrderItemService;


@Component("order.item.save")
public class SaveOrderItemCommand extends BaseCommand<OrderItem, OrderItem> {
	
	@Autowired
	private OrderItemService orderItemService;

	@Override
	public Response<OrderItem> execute(Request<OrderItem> request) {
		OrderItem orderItem = orderItemService.saveOrderItem(request.getBody());
		return this.buildResponse(request.getMeta(), orderItem);
	}

}
