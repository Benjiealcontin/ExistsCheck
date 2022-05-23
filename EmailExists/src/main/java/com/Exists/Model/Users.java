package com.Exists.Model;

public class Users {
	private int ID;
	private String Firstname;
	private String Lastname;
	private String Email;
	private String Password;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String firstname, String lastname, String email, String password) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		Email = email;
		Password = password;
	}

	public Users(int iD, String firstname, String lastname, String email, String password) {
		super();
		ID = iD;
		Firstname = firstname;
		Lastname = lastname;
		Email = email;
		Password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
