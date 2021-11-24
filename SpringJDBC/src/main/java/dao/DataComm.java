package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataComm implements Communication {

	static String qry;
	static Connection dbCon;
	static Statement theStatement;
	static ResultSet theResultSet;
	static PreparedStatement thePreparedStatement;
	static int a;
	Scanner scan = new Scanner(System.in);

	public DataComm() {
		try {
			// Load the DB Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
			theStatement = dbCon.createStatement();
			System.out.println("Connected to the database now...");

		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect to the database : " + e.getMessage());
		}
	}

	@Override
	public void Insert(String name, String loc, Integer pass) {
		qry = "insert into Accounts(Name, loc, pass) values(?,?,?)";
		try {
//        	Get the PreparedStatement object
			thePreparedStatement = dbCon.prepareStatement(qry);

//			Put the values for ?
			thePreparedStatement.setString(1, name);
			thePreparedStatement.setString(2, loc);
			thePreparedStatement.setInt(3, pass);

//			Execute the query
			if (thePreparedStatement.executeUpdate() > 0)
				System.out.println("User added successfully...");

		} catch (SQLException e) {
			System.out.println("Issues with PreparedStatement insert query : " + e.getMessage());
		}

	}

	@Override
	public void ChechBal(int num, int pass) {
		qry = "select bal,pass from accounts where AccNo = ? and pass = ?";
		int count = 0;

		try {
			thePreparedStatement = dbCon.prepareStatement(qry);
			thePreparedStatement.setInt(1, num);
			thePreparedStatement.setInt(2, pass);

			theResultSet = thePreparedStatement.executeQuery();

			while (theResultSet.next()) {
				System.out.println("Your Account Balance  ::  " + theResultSet.getInt(1));
				count++;
			}
			if (count == 0) {
				System.err.println("Opps....Invalid AccountNumber or Password ....!!");
			}
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}
	}

	public void Depos(int num, int pass, int bal) {
		qry = "update accounts set bal =bal+? where AccNo = ? and pass = ?";

		try {
			thePreparedStatement = dbCon.prepareStatement(qry);

			thePreparedStatement.setInt(1, bal);
			thePreparedStatement.setInt(2, num);
			thePreparedStatement.setInt(3, pass);
			if (thePreparedStatement.executeUpdate() > 0)
				System.out.println("Amount " + bal + " INR  added into " + num + " Account");

		} catch (SQLException e) {
			System.out.println("Issues with the update query : " + e.getMessage());
		}

	}

	public void With(int num, int pass, int bal) {
		qry = "update accounts set bal = bal-? where AccNo = ? and pass = ?";
		try {
			thePreparedStatement = dbCon.prepareStatement(qry);

			thePreparedStatement.setInt(3, pass);
			thePreparedStatement.setInt(2, num);
			thePreparedStatement.setInt(1, bal);

			if (thePreparedStatement.executeUpdate() > 0)
				System.out.println("Withdarwl successfull...!!!");
			else
				System.err.println("Opps....Invalid AccountNumber or Password ....!!");
		} catch (SQLException e) {
			System.out.println("Issues with the update query : " + e.getMessage());
		}

	}

	public void Trans(int num1, int num2, int pass, int amount) {
		String sql1 = "update accounts set bal= bal - ? where AccNo = ? and pass = ?";
		try {

			thePreparedStatement = dbCon.prepareStatement(sql1);
			thePreparedStatement.setInt(1, amount);
			thePreparedStatement.setInt(2, num1);
			thePreparedStatement.setInt(3, pass);
			thePreparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql2 = "update accounts set bal= bal + ? where AccNo = ?";
		try {

			thePreparedStatement = dbCon.prepareStatement(sql2);
			thePreparedStatement.setInt(1, amount);
			thePreparedStatement.setInt(2, num2);
			thePreparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Trasferred ....!!!");
	}

}
