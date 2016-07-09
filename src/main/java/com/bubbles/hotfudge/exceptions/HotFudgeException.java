package com.bubbles.hotfudge.exceptions;

public class HotFudgeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6806167555555665564L;
	private int httpStatusCode;
	
	public HotFudgeException(String message) {
	    super(message);
	}
	
	public HotFudgeException(String message, int httpStatusCode) {
	    super(message);
	    this.httpStatusCode = httpStatusCode;
	}

	public void setStatusCode(int statusCode) {
		this.httpStatusCode = statusCode;
	}
	
	public int getStatusCode() {
		return httpStatusCode;
	}

}
