package com.shop.online.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7718124905285786943L;

	private String countryCode;
	
	private String language;
	
	private String version;
	
	

}
