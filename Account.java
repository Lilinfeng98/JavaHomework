package assignment_3;

import java.util.Date;

public class Account {
	
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date datecreated;
	
	public Account() {
		Date datecreated = new Date();
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.datecreated = new Date();
	}
	
	public int getId() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double annualInterestRate() {
		return annualInterestRate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getDate() {
		return datecreated;
	}
	
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = annualInterestRate / 12;
		double monthlyInterest = balance * monthlyInterestRate / 100;
		return monthlyInterest;
	}
	
	public void withDraw(double cash) {
		if(balance < cash) {
			System.out.println("Insufficient funds!");
			return;
		}
		balance -= cash; 
	}
	
	public void deposit(double cash) {
		balance += cash;
	}
	

	public static void main(String[] args) {
		Account test_account = new Account(1122, 20000);
		test_account.setAnnualInterestRate(4.5);
		test_account.withDraw(2500);
		test_account.deposit(3000);
		
		double bal = test_account.getBalance();
		double monthInterest = test_account.getMonthlyInterestRate();
		Date date = test_account.getDate();
		
		System.out.println("Balance: " + bal + ", MonthlyInterest: " + monthInterest + ", Datecreated: " + date);
	}
}
