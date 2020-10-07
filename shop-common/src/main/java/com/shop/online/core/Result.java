package com.shop.online.core;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable{
	
	private static final long serialVersionUID = -8782980958447766466L;

	private String code;
	
	private String desc;

}
