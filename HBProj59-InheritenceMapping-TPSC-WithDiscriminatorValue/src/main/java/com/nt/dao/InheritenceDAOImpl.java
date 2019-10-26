package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class InheritenceDAOImpl implements InheritenceDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person per=null;
		Employee emp=null;
		Customer cust=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare objects
		per=new Person();
		per.setName("raja"); per.setCompany("HCL");
		emp=new Employee();
		emp.setName("ravi"); emp.setCompany("Wipro");
		emp.setSalary(90000);emp.setDesg("SE");
		cust=new Customer();
		cust.setName("suresh"); cust.setCompany("Amazon");
		cust.setAddrs("hyd"); cust.setBillAmt(9000.55f);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.save(per);
			  ses.save(emp);
			  ses.save(cust);
			flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//saveData
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query1=null,query2=null,query3=null;
		List<Person> list1=null;
		List<Employee> list2=null;
		List<Customer> list3=null;
		//get Sesion 
		ses=HibernateUtil.getSession();
		//Load objects
		try {
		 query1=ses.createQuery("from Person");
		 list1=query1.getResultList();
		 list1.forEach(per->{
			 System.out.println(per);
		 });
		 System.out.println(".......................");
		 query2=ses.createQuery("from Employee");
		 list2=query2.getResultList();
		 list2.forEach(emp->{
			 System.out.println(emp);
		 });
		 System.out.println(".......................");
		 query3=ses.createQuery("from Customer");
		 list3=query3.getResultList();
		 list3.forEach(cust->{
			 System.out.println(cust);
		 });
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close Session obj
			HibernateUtil.closeSession(ses);
			
		}
	}//method
	
}//class
