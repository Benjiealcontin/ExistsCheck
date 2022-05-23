package com.Exists.Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Exists.Dao.CrudOperation;
import com.Exists.Model.Users;

/**
 * Servlet implementation class Adduser
 */
@WebServlet("/UserVerify")
public class UserVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserVerify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String url = "jdbc:mysql://localhost:3306/airline_reservation";
		final String user = "root";
		final String password = "";
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			// feth form value
			String email = request.getParameter("email");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String pass = request.getParameter("pass");

			Users bb = new Users();
			bb.setFirstname(fname);
			bb.setLastname(lname);
			bb.setEmail(email);
			bb.setPassword(pass);

			CrudOperation ope = new CrudOperation();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM `users` WHERE Email =?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				boolean b = rs.next();
				if (!b) {
					int i = ope.Adduser(bb);
					if (i > 0) {
						response.sendRedirect("welcome.jsp");
					}
				} else {
					response.sendRedirect("exists.jsp");

				}
				rs.close();
				ps.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
