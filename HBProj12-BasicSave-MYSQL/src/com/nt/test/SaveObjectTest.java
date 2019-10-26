package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {
	public static void main(String[] args) {
		 Employee emp=null;
		 Transaction tx=null;
		 boolean flag=false;
		 int idVal=0;
		 Session ses=null;
		 //get Session
		 ses=HibernateUtil.getSession();
		 //create Entity class obj with Data
		emp=new Employee();
		 emp.setEno(7099); emp.setEname("raja");
		 emp.setDesg("CLERK"); emp.setSalary(9000);
		 try {
			 //begin Transaction
			 tx=ses.beginTransaction();
			   //save object
			 idVal=(Integer)ses.save(emp);
			 System.out.println("Generated Id value::"+idVal);
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
				 System.out.println("Object is saved");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object is rolleback");
			 }
			 //close HB ses,SessionFactory objs
			 HibernateUtil.closeSession(ses);
			 HibernateUtil.closeSessionFactory();
		 }//finally 
	}//main
}//class
