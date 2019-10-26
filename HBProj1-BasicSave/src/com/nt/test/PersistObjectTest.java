package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class PersistObjectTest {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory factory = null;
		Session ses = null;
		Employee emp = null;
		Transaction tx = null;
		boolean flag = false;
		int idVal = 0;
		// BootStrap Hibernate
		cfg = new Configuration();
     
		// Locate and read cfg file,mapping files
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		   
		// build SessionFactory
		factory = cfg.buildSessionFactory();
		// Open Session
		ses = factory.openSession();
		/*
		try {
			tx = ses.beginTransaction();
			// create Entity class obj with Data
			emp = new Employee();
			emp.setEno(1028);
			emp.setEname("raja");
			emp.setDesg("CLERK");
			emp.setSalary(9000);
			// save object
			ses.persist(emp);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Perform TxMgmt
			if (flag) {
				tx.commit();
				System.out.println("Object is saved");
			} else {
				tx.rollback();
				System.out.println("Object is not saved");
			}

			// close Session,SessioFactory objs
			ses.close();
			factory.close();
		} // finally */
	}// main
}// class
