package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public interface Communication {
	public static final String URLTOCONNECT = "jdbc:mysql://localhost:3306/parallel2";
	public static final String USERNAME = "root";
	public static final String USERPASSWORD = "8008";

	void Insert(String name, String loc, Integer pass);

	void ChechBal(int num, int pass);

	void Depos(int num, int pass, int bal);

	void With(int num, int pass, int bal);

	void Trans(int num1, int num2, int pass, int amount);
}
