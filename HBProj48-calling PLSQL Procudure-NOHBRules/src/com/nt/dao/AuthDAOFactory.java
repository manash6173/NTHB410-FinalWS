package com.nt.dao;

public class AuthDAOFactory {
	
	public  static  AuthDAO getInstance() {
		//return  new AuthDAOImpl();
		//return  new AuthDAOImpl1();
		return new AuthDAOImpl2();
	}

}
