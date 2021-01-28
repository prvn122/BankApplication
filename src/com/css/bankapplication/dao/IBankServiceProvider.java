package com.css.bankapplication.dao;
import com.css.bankapplication.dto.BankAccount;
import com.css.bankapplication.exception.InsufficientBalanceException;
import com.css.bankapplication.exception.InvalidAccountNoException;


public interface IBankServiceProvider {
	BankAccount  checkAccount (String accountNo) throws InvalidAccountNoException;
	double getBalance(String accountNo) throws InvalidAccountNoException;
	boolean depositMoney(String accountNo,double amount) throws InvalidAccountNoException;
	boolean withdrawMoney(String accountNo,double amount) throws InvalidAccountNoException,InsufficientBalanceException;
	boolean transferMoney(String fromAccountNo,String toAccount,double amount)throws InvalidAccountNoException,InsufficientBalanceException;
	

}
