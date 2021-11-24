package ui;

import java.sql.DriverManager;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.DetailsValidation;
import services.Validation;

public class Main  {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ConfigFile.xml");
		Validation valid = (Validation) context.getBean("valid", Validation.class);

		System.out.println("WELCOME TO ABCD BANK!");
		System.out.println("please choose your options from below:");
		System.out.println("Please entert 1 for create new Account");
		System.out.println("Please entert 2 for check Balence");
		System.out.println("Please entert 3 for deposit money into your Account");
		System.out.println("Please entert 4 for withdraw money from your Account");
		System.out.println("Please entert 5 for Transfer money");
		System.out.println("Please entert 6 for mini statement");

		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		if (option == 1) {
			valid.CreateAcc();
		}
		if (option == 2) {
			valid.CheckBal();
		}

		if (option == 3) {
			valid.Deposit();
		}
		if (option == 4) {
			valid.Withdraw();
		}
		if (option == 5) {
			valid.Transfer();
		}
		if (option == 6) {

		}

	}

	

}
