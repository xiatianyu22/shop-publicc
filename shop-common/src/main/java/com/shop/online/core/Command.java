package com.shop.online.core;

public interface Command<T, K> {
	
	Response<T> execute(Request<K> request);

}
