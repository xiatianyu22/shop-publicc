package com.shop.online.order.list;

import lombok.Data;

@Data
public class ListOrderRequestBody {
	
	private Integer page; 
	private Integer size; 
	private Boolean desc;
	private String key;

}
