package com.shop.online.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shop.online.core.Request;
import com.shop.online.core.Response;
import com.shop.online.core.Result;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private Request request;

    @ModelAttribute
    public void setRequest(@RequestBody Request request) {
        this.request = request;
    }

	
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Response<String> handleResourceNotFound(final BusinessException exception) {
		Result result = new Result(exception.getCode(), exception.getMessage());
		Response<String> error = new Response<>(this.request.getMeta(), null, result);
		
		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Response<String> handleException(final Exception exception) {
		Result result = new Result("Unknown", exception.getMessage());
		Response<String> error = new Response<>();

		return error;
	}

}
