package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTestWithFlush {

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
		try {
		 //create Entity class obj with Data
		emp=new Employee();
		 emp.setEno(1067); emp.setEname("raja");
		 emp.setDesg("CLERK"); emp.setSalary(9000);
			   //save object
			 //idVal=(Integer)ses.save(emp);
		      ses.persist(emp);
			 ses.flush();
			 //System.out.println("Obj saved --->Generated Id value::"+idVal);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 ses.close();
			 factory.close();
		 }//finally 
	}//main
}//class
