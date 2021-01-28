package com.css.bankapplication.dto;
import com.css.bankapplication.dao.IBankServiceProvider;
import com.css.bankapplication.exception.*;
import java.util.Arrays;

public class Bank implements IBankServiceProvider {
    BankAccount[] bankAccounts;
	private String IFSCCode;
	private String bankAccount;
	public Bank(BankAccount[] bankAccounts, String iFSCCode, String bankAccount) {
		super();
		this.bankAccounts = bankAccounts;
		IFSCCode = iFSCCode;
		this.bankAccount = bankAccount;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankAccount checkAccount(String accountNo)throws  InvalidAccountNoException {
		BankAccount foundAccount=null;
		for(BankAccount account:bankAccounts) {
			if(account.getAccountno().equals(accountNo)) {
				foundAccount=account;
				break;
			}
		}
		if(foundAccount==null) {
			throw new InvalidAccountNoException();
		}
		return foundAccount;
	}
	public double getBalance(String accountNo)throws InvalidAccountNoException {
		double balance=0.0;
		BankAccount foundAccount=checkAccount(accountNo);
		balance=foundAccount.getBalance();
		return balance;
	}
	public boolean depositMoney(String accountNo, double amount) throws InvalidAccountNoException {
		boolean flagDeposit = false;
		BankAccount foundAccount = checkAccount(accountNo);
		if(foundAccount!=null) {
			foundAccount.setBalance(foundAccount.getBalance()+amount);
			flagDeposit = true;
		}
		return true;
	}
	public boolean withdrawMoney(String accountNo,double amount)throws InvalidAccountNoException {
		
		boolean flagwithdraw = false;
		BankAccount foundAccount=checkAccount(accountNo);
		if(foundAccount!=null) {
			if(foundAccount.getBalance()>amount) {
				foundAccount.setBalance(foundAccount.getBalance()-amount);
				flagwithdraw= true;
				}else {
					throw new InvalidAccountNoException();
				}
		}
		return flagwithdraw;
		
	}
	public boolean transferMoney(String fromAccountNo,String toAccountNo,double amount)throws InvalidAccountNoException,InsufficientBalanceException {
		boolean transferflag= false;
		boolean flagwithdraw= withdrawMoney(fromAccountNo,amount);
		boolean flagDeposit=depositMoney(toAccountNo, amount);
		if(flagwithdraw) {
			flagDeposit = depositMoney(toAccountNo, amount);
	
		}
		if(flagDeposit )
			transferflag=true;
		else
			depositMoney(fromAccountNo,amount);
		return transferflag;
		
	}
	public BankAccount[] getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(BankAccount[] bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	@Override
	public String toString() {
		return "Bank [bankAccounts=" + Arrays.toString(bankAccounts) + ", IFSCCode=" + IFSCCode + ", bankAccount="
				+ bankAccount + "]";
	}
	
	
	

}
