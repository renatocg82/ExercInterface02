package model.entities;

import java.time.format.DateTimeFormatter;

public class PayPalService implements PayService{
	
	Contract contract;
	Integer installments;
	
	public PayPalService() {
		
	}
	
	public PayPalService(Contract contract , Integer installments) {
	this.contract = contract;
	this.installments = installments;
	}
	
	@Override
	public void processContract(Contract contract, Integer installents) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		double interest = 0.01;
		double paymentTax = 0.02;
		double basicInstallment = contract.getTotalValue() / installments;
		
		System.out.println("-------------------");
		System.out.println("Parcelas: ");
		double installMonth;
		double installMonthNoTax;
		Installment tempInstallment = new Installment();
		for (int i = 1 ; i <= installments ; i = i + 1) {
			installMonthNoTax = ((basicInstallment) + (interest*i*basicInstallment));
			installMonth = installMonthNoTax + installMonthNoTax*paymentTax;
		
			tempInstallment.setAmount(installMonth);
			tempInstallment.setDueDate((contract.getDate().plusMonths(i)));
			
			contract.getInstallments().add(new Installment (contract.getDate().plusMonths(i),  installMonth));
			
			System.out.print((contract.getDate().plusMonths(i)).format(dtf) + 
					" - " + 
					String.format("%.2f", installMonth));
			System.out.println();		
		}
		System.out.println("-------------------");
	}
}
