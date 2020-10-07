package com.shop.online.core;


public abstract class BaseCommand<T, K> implements Command<T, K> {

	public abstract Response<T> execute(Request<K> request) ;
	
	protected Response<T> buildResponse(Meta meta, T order){
		Result result = new Result("000000", "success");
		return new Response<T> (meta, order, result);
	}
	

}
