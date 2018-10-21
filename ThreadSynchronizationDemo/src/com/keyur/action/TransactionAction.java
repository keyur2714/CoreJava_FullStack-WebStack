package com.keyur.action;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.keyur.model.Account;
import com.keyur.util.TransactionThread;

public class TransactionAction {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		TransactionThread transactionThread = new TransactionThread();

		Account fromAccount = new Account();
		fromAccount.setAccountHolderName("Keyur");
		fromAccount.setAccountNo(9898121212l);
		fromAccount.setBalance(20000.0);
		
		transactionThread.setAmount(1000);
		transactionThread.setFromAccount(fromAccount);
		
		Thread webActivity = new Thread(transactionThread);
		webActivity.setPriority(10);
/*		Thread mobileActivity = new Thread(transactionThread);
		Thread paytmActivity = new Thread(transactionThread);
		Thread googlePayActivity = new Thread(transactionThread);
		
		webActivity.start();
		mobileActivity.start();
		paytmActivity.start();
		googlePayActivity.start();
*/		
		
		Future<Double> future;
		
		for(int i=1;i<=10;i++) {
			future = (Future<Double>) executor.submit(webActivity);
			if(future.isDone()) {
				try {
					System.out.println(future.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
