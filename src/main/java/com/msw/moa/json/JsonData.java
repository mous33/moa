package com.msw.moa.json;

import java.util.List;
import java.util.Map;

/**
 * JSONデータクラス
 * 
 * @author 王磊
 */
public class JsonData {

	private boolean result = true;
	private String message = "";
	private Object data;
	private Map<String, String> errors;
	private List<String> globalErrors;

	public JsonData() {
	}

	public JsonData(Object data) {
		this.data = data;
	}

	public JsonData(boolean result, String message) {
		this.result = result;
		this.message = message;
	}

	public JsonData(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public JsonData(boolean result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public JsonData(Map<String, String> errors) {
		this.result = false;
		this.errors = errors;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public List<String> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(List<String> globalErrors) {
		this.globalErrors = globalErrors;
	}

}
