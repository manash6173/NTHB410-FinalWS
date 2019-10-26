package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		emp=new Employee();
		emp.setEno(9017); emp.setEname("raja");
		//emp.setDesg("CLERK");
		emp.setSalary(9000);
        try {
        	//begin Tx
        	tx=ses.beginTransaction();
        	 //save object
        	idVal=(int) ses.save(emp);
        	System.out.println("Generated id value::"+idVal);
        	flag=true;
        }//try
        catch(Exception e) {
        	e.printStackTrace();
        	flag=false;
        }
        finally {
        	if(flag) {
        		tx.commit();
        		System.out.println("Object is saved");
        	}
        	else {
        		tx.rollback();
        		System.out.println("Object is not saved");
        	}
        	//close Object
        	HibernateUtil.closeSession(ses);
        	HibernateUtil.closeSessionFactory();
        }//finally
	}//main
}//class
