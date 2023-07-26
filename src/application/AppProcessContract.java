package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.PayPalService;

public class AppProcessContract {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scString = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		

		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		Integer tempNumb = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		String strDate = scString.nextLine();
		LocalDate tempDate = LocalDate.parse(strDate, df);
		System.out.print("Valor do contrato: ");
		Double tempTotalValue = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		Integer tempNumbInstallments = sc.nextInt();
		
		Contract c1 = new Contract(tempNumb, tempDate, tempTotalValue);
		
		c1.setPayService(new PayPalService(c1, tempNumbInstallments));
		
		c1.getPayService().processContract(c1, tempNumbInstallments);
		
		sc.close();
		scString.close();
	}

}
