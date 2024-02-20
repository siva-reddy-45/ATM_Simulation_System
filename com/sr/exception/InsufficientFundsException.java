package com.sr.exception;

public class  InsufficientFundsException extends Exception {

	public InsufficientFundsException(){
		super();
	}
	public InsufficientFundsException(String  errMsg){
		super(errMsg);
	}
}