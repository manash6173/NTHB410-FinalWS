package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public boolean transferEmployee(int empNo) {
		Session oraSes=null;
		Session mysqlSes=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session objects
		oraSes=OracleHibernateUtil.getSession();
		mysqlSes=MySQLHibernateUtil.getSession();
		//get Object from mysql DB s/w
		emp=mysqlSes.get(Employee.class,empNo);
		if(emp==null) {
			return false;
		}
		else {
		  try {	
		  //begin Transaction
			tx=oraSes.beginTransaction();
			  oraSes.save(emp);
			flag=true;
		  }//try
		  catch(Exception e) {
			  e.printStackTrace();
			  flag=false;
		  }
		  finally {
			  if(flag) {
				  tx.commit();
				  flag=true;
			  }
			  else {
				  tx.rollback();
				  flag=false;
			  }
			  //close Session objs
			  MySQLHibernateUtil.closeSession(mysqlSes);
			  OracleHibernateUtil.closeSession(oraSes);
		  }//finally
		  
		}//else
		return flag;
	}//method

}//class
