package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class RequestThread extends Thread {
	SessionFactory factory=null;
	public RequestThread(SessionFactory factory) {
		this.factory=factory;
	}
	
	@Override
	public void run() {
		Employee emp=null;
		Transaction tx=null;
		int idVal=0;
		boolean flag=false;
		Session ses=null;
		emp=new Employee();
		emp.setEno(9089); emp.setEname("rajesh");
		emp.setDesg("CLERK"); emp.setSalary(9000);
		ses=factory.openSession();
		try {
			tx=ses.beginTransaction();
			idVal=(int) ses.save(emp);
			System.out.println("Generated id values::"+idVal);
			flag=true;
			Thread.sleep(10000);
		
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
			//HibernateUtil.closeSession(ses);
		}//finally
	}

}
