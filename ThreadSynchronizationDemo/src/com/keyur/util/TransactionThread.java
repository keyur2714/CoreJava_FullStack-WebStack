package com.keyur.util;

import com.keyur.model.Account;
import com.keyur.service.AccountService;

public class TransactionThread implements Runnable {

	private double amount;
	private Account fromAccount;
	private Account toAccount;

	AccountService accountService = new AccountService();

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	@Override
	public void run() {
		
		double balance = accountService.widhdraw(fromAccount, amount);
		System.out.print(Thread.currentThread()+ " ====> "+"Current Balance is : " + balance);		
		System.out.println("");

	}

}
