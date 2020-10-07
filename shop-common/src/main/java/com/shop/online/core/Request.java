package com.shop.online.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6239025434716309713L;

	private Meta meta;
	
	private T body;
	

}
