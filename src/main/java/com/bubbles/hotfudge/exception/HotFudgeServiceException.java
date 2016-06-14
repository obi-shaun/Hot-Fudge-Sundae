package com.bubbles.hotfudge.exception;

public class HotFudgeServiceException extends Exception {
	
	private Exception originalException;
	
	public HotFudgeServiceException() {}

	public HotFudgeServiceException(String message) {
	    super(message);
	}
	
	public HotFudgeServiceException(Exception orginalException, String message) {
	    super(message);
	    this.setOriginalException(orginalException);
	}

	public Exception getOriginalException() {
		return originalException;
	}

	public void setOriginalException(Exception originalException) {
		this.originalException = originalException;
	}

}
