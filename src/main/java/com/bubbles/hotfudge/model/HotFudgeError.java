package com.bubbles.hotfudge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * This class serves as a model for all
 * http errors for the purpose of being transformed to
 * json before returning to user.
 */
public class HotFudgeError {
	
	private String message;
	private int httpStatusCode;
	
	@JsonCreator
	public HotFudgeError(@JsonProperty("message") String message, @JsonProperty("httpStatusCode") int httpStatusCode) {
		this.setMessage(message);
		this.setHttpStatusCode(httpStatusCode);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getMessage() {
		return message;
	}
	
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

}
