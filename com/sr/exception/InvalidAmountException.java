package com.sr.exception;

public class  InvalidAmountException extends Exception {

	public InvalidAmountException(){
		super();
	}

	public InvalidAmountException(String  errMsg){
		super(errMsg);
	}
}