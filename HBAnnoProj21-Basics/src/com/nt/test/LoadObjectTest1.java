package com.nt.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.entity.IEmp;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		IEmp emp=null;
		Transaction tx=null;
		
		//get Session
		ses=HibernateUtil.getSession();
        try {
          //load object
        	emp=ses.load(Employee.class,9002);
        	System.out.println(emp.getClass()+" "+emp.getClass().getSuperclass()+" "+Arrays.toString(emp.getClass().getInterfaces()));
        		//System.out.println(emp.getEno()+" "+emp.getEname()+" "+emp.getDesg()+" "+emp.getSalary());
        }//try
        catch(Exception e) {
        	e.printStackTrace();
        	System.out.println("Record not found");
        }
        finally {
        	//close Object
        	HibernateUtil.closeSession(ses);
        	HibernateUtil.closeSessionFactory();
        }//finally
	}//main
}//class
