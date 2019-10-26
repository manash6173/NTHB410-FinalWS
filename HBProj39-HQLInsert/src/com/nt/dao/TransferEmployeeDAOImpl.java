package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class TransferEmployeeDAOImpl implements TransferEmployeeDAO {
  private static final String HQL_INSERT="INSERT INTO NGOMember(mid,mname,desg,salary) SELECT e.eno,e.ename,e.desg,e.salary FROM Employee e WHERE e.salary>=:min and e.salary<=:max";
	@Override
	public int trasferEmployeesAsNGOs(float startSalary, float endSalary) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		int count=0;
	  //get SEssion	
		ses=HibernateUtil.getSession();
	  //prepare query
		query=ses.createQuery(HQL_INSERT);
		//set param values
		query.setParameter("min",startSalary);
		query.setParameter("max", endSalary);
	  try {
		 //begin Tx
		  tx=ses.beginTransaction();
		  count=query.executeUpdate();
		  flag=true;
	  }
	  catch(Exception e) {
		  e.printStackTrace();
		  flag=false;
	  }
	  finally {
		  if(flag) {
			  tx.commit();
		  }
		  else {
			  tx.rollback();
		  }
		  HibernateUtil.closeSession(ses); 
	  }
		return count;
	}//method

}//class
