package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthDAOImpl1 implements AuthDAO {
  private static final String AUTH_QUERY="{CALL P_AUTH(?,?,?)}";
	@Override
	public String authenticate(String user, String pwd) {
		Session ses=null;
		String result=null;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//use inner class
		result=ses.doReturningWork(new ReturningWork<String>() {
			
			@Override
			public String execute(Connection con) throws SQLException {
				CallableStatement cs=null;
				String result=null;
				//create CallableStatement obj
				cs=con.prepareCall(AUTH_QUERY);
				//register OUT params with JDBC types
				cs.registerOutParameter(3,Types.VARCHAR);
				//set values to IN Params
				cs.setString(1,user);
				cs.setString(2,pwd);
				//execute Pl/SQL procedure
				cs.execute();
				//gather result out params
				result=cs.getString(3);
				return result;
			}//execute(-)
		  }//anymous inner class
		); //method call
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		return result;
	}//method
	

}//outer class
