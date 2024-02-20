package com.sr.blogic;

import com.sr.exception.InvalidAmountException;
import com.sr.exception.InsufficientFundsException;

public class KotakBankCard implements ATMCard{

	private double balance;

	public void deposit(double amt)
					throws InvalidAmountException{
		
		if(amt <= 0)
			throw new InvalidAmountException(
								"Donot pass -ve num or zero ");
		
		balance = balance + amt;
	}

	public void withdraw(double amt)
							throws InvalidAmountException,
										InsufficientFundsException{
		
		if(amt <= 0)
			throw new InvalidAmountException(
								"Do not pass -ve num or zero");	
		
		if(amt > balance)
			throw new InsufficientFundsException(
												"Insufficient Funds");
		
		balance = balance - amt;
	}

	public void currentBalance(){
		System.out.println(balance);
	}

}
