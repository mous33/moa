package com.msw.moa.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msw.moa.json.JsonData;

/**
 * 異常処理
 * 
 * @author 王磊
 */
@ControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	JsonData handleException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return new JsonData(errors);
	}
}
