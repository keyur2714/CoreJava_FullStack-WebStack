package com.keyur.service;

import com.keyur.model.Account;

public class AccountService {

	public double widhdraw(Account fromAccount,double amount) {	
		
		try {
			if(fromAccount.getBalance() < amount) {
				this.diposite(fromAccount, 10000);				
			}
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		synchronized(fromAccount) {
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			return fromAccount.getBalance();
		}		
		//return fromAccount.getBalance();				
	}
	
	public double diposite(Account toAccount,double amount) {		
		return toAccount.getBalance() + amount;				
	}
	
}
