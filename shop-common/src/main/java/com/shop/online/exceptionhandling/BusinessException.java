package com.shop.online.exceptionhandling;

public class BusinessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 245705732858281462L;
	private String code;
	
	public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
