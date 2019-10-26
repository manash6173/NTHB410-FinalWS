package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Employee emp=null,emp1=null;
		int idVal=0,idVal1=0;
		//get Session 
		ses=HibernateUtil.getSession();
		//prpeare object
		emp=new Employee();
		emp.setEno(9089); emp.setEname("rajesh");
		emp.setDesg("CLERK"); emp.setSalary(9000);
		emp1=new Employee();
		emp1.setEno(9089); emp1.setEname("rajesh");
		emp1.setDesg("CLERK"); emp1.setSalary(9000);
		try {
			tx=ses.beginTransaction();
			idVal=(int) ses.save(emp);
			idVal1=(int) ses.save(emp1);
			System.out.println("Generated id values::"+idVal+" "+idVal1);
			flag=true;
		}
		catch(Exception e) {
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
