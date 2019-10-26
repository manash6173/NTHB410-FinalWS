package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class UpdateObjectTest {

	public static void main(String[] args) {
		 Configuration cfg=null;
		 SessionFactory factory=null;
		 Session ses=null;
		 Employee emp=null;
		 Transaction tx=null;
		 boolean flag=false;
		 int idVal=0;
		//BootStrap Hibernate 
		 cfg=new Configuration();
		 
		 //Locate and read cfg file,mapping files
		 cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		 //build SessionFactory
		 factory=cfg.buildSessionFactory();
		 //Open Session
		 ses=factory.openSession();

		 
		
		  //Load the object
		  emp=ses.get(Employee.class,1067);
		  if(emp==null) {
			  System.out.println("record not found");
		  }
		  else {
		 try {
			 //begin Transaction
			 tx=ses.beginTransaction();
			  
			   //modify object
			 emp.setDesg("Sr.MANAGER");
			 ses.update(emp);
			 flag=true;
		 }//try
		 catch(Exception e) {
			 flag=false;
			 e.printStackTrace();
		 }
		 finally {
			 //perform Tx Mgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("Object is updated");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object is not updated");
			 }
			 //close HB ses,SessionFactory objs
			 ses.close();
			 factory.close();
		 }//finally 
		  }//else
	}//main
}//class
