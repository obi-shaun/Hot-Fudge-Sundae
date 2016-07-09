package com.bubbles.hotfudge.exceptions;

public class HotFudgeServiceException extends HotFudgeException {
	
	private static final long serialVersionUID = -7343729292472623794L;

	//TODO: httpstatus code enum
	public HotFudgeServiceException(String message) {
	    super(message);
	}

}
