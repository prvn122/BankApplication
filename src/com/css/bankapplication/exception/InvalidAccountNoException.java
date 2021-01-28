package com.css.bankapplication.exception;

public class InvalidAccountNoException extends Exception {
	private String errormsg="Invalid Account No....";
	public InvalidAccountNoException() {
		super();
	}

	public InvalidAccountNoException(String errormsg) {
		super();
		this.errormsg =errormsg ;
	}
	public String getMessage() {
		return this.errormsg;
	}

	
	

}
