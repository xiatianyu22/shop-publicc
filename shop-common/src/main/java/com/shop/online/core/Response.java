package com.shop.online.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7599974348383348269L;

	private Meta meta;
	
	private T body;
	
	private Result result;
	
	

}
