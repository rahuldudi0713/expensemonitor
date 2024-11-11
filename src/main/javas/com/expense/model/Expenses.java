package com.expense.model;

public class Expenses {
	private int S_No;
	private String Trip_Name;
	private int Budget;
	private int Expense_Amount;
	private String Expense_reason;
	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expenses(int s_No, String trip_Name, int budget, int expense_Amount, String expense_reason) {
		super();
		S_No = s_No;
		Trip_Name = trip_Name;
		Budget = budget;
		Expense_Amount = expense_Amount;
		Expense_reason = expense_reason;
	}
	public int getS_No() {
		return S_No;
	}
	public void setS_No(int s_No) {
		S_No = s_No;
	}
	public String getTrip_Name() {
		return Trip_Name;
	}
	public void setTrip_Name(String trip_Name) {
		Trip_Name = trip_Name;
	}
	public int getBudget() {
		return Budget;
	}
	public void setBudget(int budget) {
		Budget = budget;
	}
	public int getExpense_Amount() {
		return Expense_Amount;
	}
	public void setExpense_Amount(int expense_Amount) {
		Expense_Amount = expense_Amount;
	}
	public String getExpense_reason() {
		return Expense_reason;
	}
	public void setExpense_reason(String expense_reason) {
		Expense_reason = expense_reason;
	}
	@Override
	public String toString() {
		return "Expenses [S_No=" + S_No + ", Trip_Name=" + Trip_Name + ", Budget=" + Budget + ", Expense_Amount="
				+ Expense_Amount + ", Expense_reason=" + Expense_reason + "]";
	}
	
	
	

}
