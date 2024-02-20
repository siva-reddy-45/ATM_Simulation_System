package com.sr.blogic;

import com.sr.exception.InvalidAmountException;
import com.sr.exception.InsufficientFundsException;

public class BankAccount {
	private double balance;

	public void deposit(double amt)
									throws InvalidAmountException{
		if(amt < 0){
			throw new InvalidAmountException(
									"Negative amount is not allowed");
		}

		this.balance = this.balance + amt;
	}

	public void withdraw(double amt)									
								throws InvalidAmountException,
												InsufficientFundsException{
	
		if(amt < 0){	
			throw  new InvalidAmountException(
									"NegativeAmount is not allowed");
		}
		if(amt > balance){
			throw new InsufficientFundsException(
									"Insufficient Funds");
		}

		this.balance = this.balance - amt;
	}

	public void currentBalance(){
		System.out.println("Current Balance: "+ balance);
	}
}