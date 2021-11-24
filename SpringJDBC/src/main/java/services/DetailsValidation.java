package services;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import bean.Account;
import dao.DataComm;

public class DetailsValidation implements Validation {

//	@Autowired
//	Account account;
	@Autowired
	DataComm datacomm;

	@Override
	public void CreateAcc() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your Name::");
		String name = scan.nextLine();
		System.out.println("Please enter your Location::");
		String loc = scan.nextLine();
		System.out.println("Please choose your password::");
		Integer pass = scan.nextInt();

		datacomm.Insert(name, loc, pass);

	}

	@Override
	public void CheckBal() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your  ACC number::");
		int num = scan.nextInt();
		System.out.println("Please enter your Password::");
		int pass = scan.nextInt();

		datacomm.ChechBal(num, pass);

	}

	@Override
	public void Deposit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your  ACC number::");
		int num = scan.nextInt();
		System.out.println("Please enter your Password::");
		int pass = scan.nextInt();
		System.out.println("Please enter Deposit ammount::");
		int bal = scan.nextInt();

		datacomm.Depos(num, pass, bal);
	}

	@Override
	public void Withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your  ACC number::");
		int num = scan.nextInt();
		System.out.println("Please enter your Password::");
		int pass = scan.nextInt();
		System.out.println("Please enter withdraw ammount::");
		int bal = scan.nextInt();

		datacomm.With(num, pass, bal);

	}

	@Override
	public void Transfer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your  ACC number from which you want to transfer::");
		int num1 = scan.nextInt();
		System.out.println("Please enter your Password::");
		int pass = scan.nextInt();
		System.out.println("Please enter your  ACC number  to which you want to transfer::");
		int num2 = scan.nextInt();
		System.out.println("Please enter how much you want to transfer::");
		int amount = scan.nextInt();

		datacomm.Trans(num1, num2, pass, amount);

	}
}
