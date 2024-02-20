package com.sr.blogic;

import com.sr.exception.InvalidAmountException;
import com.sr.exception.InsufficientFundsException;

public interface ATMCard{
	
	public abstract void deposit(double amount)
											throws InvalidAmountException;

	public abstract void withdraw(double amount)
											throws InvalidAmountException,
														 InsufficientFundsException;

	public abstract void currentBalance();

}