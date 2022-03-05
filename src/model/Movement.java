package model;

import java.time.LocalDate;

public class Movement {
	
	private LocalDate date;
	private String description;
	private double amount;
	private int type;
	
	
	
	//string
	public Movement(LocalDate date ,int type, String description, double amount) {
		this.date=date;
		this.type=type;
		this.description=description;
		this.amount=amount;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}