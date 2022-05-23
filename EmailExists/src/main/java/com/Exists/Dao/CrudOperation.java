package com.Exists.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Exists.Model.Users;

public class CrudOperation {

	private final static String url = "jdbc:mysql://localhost:3306/airline_reservation";
	private final static String user = "root";
	private final static String password = "";
	private final static String dbloader = "com.mysql.jdbc.Driver";
	private final static String ADD_USER = "INSERT INTO `users`(`Firstname`, `Lastname`, `Email`, `Password`) "
			+ "VALUES (?,?,?,?)";
	private final static String DELETE_USER = "DELETE FROM `users` WHERE ID = ?";

	public static void Driver(String dbloader) {
		try {

			Class.forName(dbloader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {

			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public static int Adduser(Users user) {
		int i = 0;
		try {
			Driver(dbloader);
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(ADD_USER);
			pst.setString(1, user.getFirstname());
			pst.setString(2, user.getLastname());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());

			i = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
