package com.css.bankapplication.dto;

public class BankAccount {
	private static int lastAssignedNo;
	static {
		lastAssignedNo=1000;
	}

	private String accountNo;
	private String accountName;
	private double balance=0;
	
	public BankAccount(String accountNo, String accountName, double balance) {
		super();
		this.accountNo = ""+lastAssignedNo++;
		this.accountName = accountName;
		this.balance = balance;
	}
	public BankAccount(String accountNo,String accountName) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance=1000.00;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static int getLastAssignedNo() {
		return lastAssignedNo;
	}
	public static void setLastAssignedNo(int lastAssignedNo) {
		BankAccount.lastAssignedNo = lastAssignedNo;
	}
	public String getAccountno() {
		return accountNo;
	}
	public void setAccountNo(String accountno) {
		this.accountNo = accountno;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountName=" + accountName + ", balance=" + balance + "]";
	}
	
	

}
