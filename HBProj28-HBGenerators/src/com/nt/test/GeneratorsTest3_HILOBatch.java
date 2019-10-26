package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest3_HILOBatch {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Employee emp=null;
		int idVal=0;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
		tx=ses.beginTransaction();
		//prpeare objects
		for(int i=1;i<=10;++i) {
		emp=new Employee();
		emp.setEno(9089); emp.setEname("rajesh");
		emp.setDesg("CLERK"); emp.setSalary(9000);
			idVal=(int) ses.save(emp);
			System.out.println("Generated id values::"+idVal);
			flag=true;
		}//for
			/*
			 * System.out.println("Going to sleep state.."); Thread.sleep(30000);
			 */
			
		}
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
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
