package com.shop.online.order.save;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.online.core.BaseCommand;
import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.exceptionhandling.BusinessException;
import com.shop.online.order.entity.Order;
import com.shop.online.order.item.entity.OrderItem;
import com.shop.online.order.service.OrderItemFeignService;
import com.shop.online.order.service.OrderService;

@Component("order.save")
public class SaveOrderCommand extends BaseCommand<Order, SaveOrderRequestBody>{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemFeignService orderItemFeignService;

	@Override
	public Response<Order> execute(Request<SaveOrderRequestBody> request) {
		//save order
		Order order = orderService.saveOrder(this.createOrder(request.getBody()));
		//save order item
		request.getBody().getOrderItems().forEach(o -> {
			o.setOrderId(order.getId());
			Request<OrderItem> req = new Request<>();
			req.setMeta(request.getMeta());
			req.setBody(o);
			orderItemFeignService.save(req);
		});
		
		return this.buildResponse(request.getMeta(), order);
	}
	
	private Order createOrder(SaveOrderRequestBody saveOrderRequestBody) {
		Order order = new Order();
		order.setCustomerName(saveOrderRequestBody.getCustomerName());
		order.setShippingAddress(saveOrderRequestBody.getShippingAddress());
		order.setOrderDesc(saveOrderRequestBody.getOrderDesc());
		return order;
	}
	
	

}
