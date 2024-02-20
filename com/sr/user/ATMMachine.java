package com.sr.user;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.sr.blogic.ATMCard;
import com.sr.exception.InvalidAmountException;
import com.sr.exception.InsufficientFundsException;

public class ATMMachine {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		while(true){
			try{
				System.out.print("\nInsert card: ");
				String cardName = scn.nextLine();
				//String cardName = scn.nextLine().trim();

				
				//Load and instantiate this given card class
				Class		cls	= Class.forName("com.sr.blogic."+cardName);
				Object		obj	= cls.newInstance();

				if(obj instanceof ATMCard){
					ATMCard card = (ATMCard)obj;
					loop:while(true){					
						System.out.println("\nChoose one option");
						System.out.println("  1. Deposit");
						System.out.println("  2. Withdraw");
						System.out.println("  3. Balance Enquiry");
						System.out.println("  4. Mini Statement");
						System.out.println("  5. Exit");
						
						System.out.print("\nEnter option num: ");
						String option = scn.nextLine();

						switch(option){
							case "1": { //deposit logic					
								while(true){
									try{
										System.out.print("\nEnter Deposit Amount: " );
										double amt = scn.nextDouble();							
										scn.nextLine();

										card.deposit(amt); 
										System.out.println(amt + " cash  credited to your account");
										card.currentBalance();

										break;
									}catch(InvalidAmountException e){
										System.out.println("<Error>: "+e.getMessage());
									}catch(InputMismatchException e){
										System.out.println("<Error>: Enter only number");
										scn.nextLine();
									}
								}//while end
								break;
							}
							
							case "2": { //withdraw logic					
								while(true){
									try{
										System.out.print("\nEnter Withdraw Amount: " );
										double amt = scn.nextDouble();							
										scn.nextLine();

										card.withdraw(amt); 
										System.out.println("Take Your Cash");
										System.out.println(amt + " cash  debited from your account");
										card.currentBalance();

										break;
									}catch(InvalidAmountException e){
										System.out.println("<Error>: "+e.getMessage());
									}catch(InsufficientFundsException e){
										System.out.println("<Error>: "+e.getMessage());
									}catch(InputMismatchException e){
										System.out.println("<Error>: Enter only number");
										scn.nextLine();
									}
								}//while end

								break;
							}
				
							case "3": { //Balance enquiry logic					
								card.currentBalance();
								break;
							}

							case "4": { //Mini Statement logic					
								System.out.println("Temporarily Out Of Service");	
								break;
							}

							case "5": { //Exit logic					
								System.out.println("       Take Your Card    ");
								System.out.println("***** Thank You, Visit Again *****");
								break loop;
							}
							default:{ //Invalid option
								System.out.println("Invalid option");	
							}
						}//switch close

					}//while close
				}
				else{
					System.out.println(cardName+ " is not an ATMCard");
				}
			}catch(ClassNotFoundException e){
				System.out.println("Could not find .class for the given class "+ e.getMessage());
			}catch(InstantiationException e){
				System.out.println("No-Param constructor is not available in the given class " );
			}catch(IllegalAccessException e){
				System.out.println("No-Param constructor is not public in the given class " );
			}
		}//while end
	}
}