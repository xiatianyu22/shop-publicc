package com.shop.online.order.save;

import java.util.Date;
import java.util.List;

import com.shop.online.order.item.entity.OrderItem;

import lombok.Data;

@Data
public class SaveOrderRequestBody {
	
	private String customerName;
	
	private Date orderDate;
	
	private String shippingAddress;
	
	private List<OrderItem> orderItems;


}
