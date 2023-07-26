package model.entities;

import java.time.LocalDate;

public class Installment {

	private LocalDate dueDate;
	private Double amount;

	public Installment() {

	}

	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}