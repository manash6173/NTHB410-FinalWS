package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		
		//get Session
		ses=HibernateUtil.getSession();
        try {
          //load object
        	emp=ses.get(Employee.class,9002);
        	if(emp!=null)
        		System.out.println(emp.getEno()+" "+emp.getEname()+" "+emp.getDesg()+" "+emp.getSalary());
        	else
        		System.out.println("record not found");
        	
        }//try
        catch(Exception e) {
        	e.printStackTrace();
        	
        }
        finally {
        	//close Object
        	HibernateUtil.closeSession(ses);
        	HibernateUtil.closeSessionFactory();
        }//finally
	}//main
}//class
