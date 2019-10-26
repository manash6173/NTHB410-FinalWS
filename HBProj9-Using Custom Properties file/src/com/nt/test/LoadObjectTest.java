package com.nt.test;

import org.hibernate.Session;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		 Session ses=null;
		 Employee emp=null;
		 //get SEssion
		 ses=HibernateUtil.getSession();
		 //create Entity class obj with Data
		 
		 try {
			 //Load object
			 emp=ses.get(Employee.class,1067);
			 if(emp==null)
				 System.out.println("record not found");
			 else
				 System.out.println(emp);
		 }//try
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 //close HB ses,SessionFactory objs
			 HibernateUtil.closeSession(ses);
			 HibernateUtil.closeSessionFactory();
		
		 }//finally 
	}//main
}//class
