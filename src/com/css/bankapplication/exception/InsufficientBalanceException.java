package com.css.bankapplication.exception;

public class InsufficientBalanceException extends Exception {
	private String errormsg="Insufficient balance in your account";

	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsufficientBalanceException (String errormsg) {
		super();
		this.errormsg =errormsg ;
	}
	public String getMessage() {
		return this.errormsg;
	}
	




}
