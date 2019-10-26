package com.nt.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.nt.entity.Employee;

public class JPQLTest2 {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		Query query=null;
		boolean flag=false;
		int count=0;
		EntityTransaction tx=null;

		//get EntityManagerFactory
		factory=Persistence.createEntityManagerFactory("pu1");
		//crete EntityManager
		manager=factory.createEntityManager();
		try {
		  //begin	
         tx=manager.getTransaction();
         tx.begin();
          //get Access to named query
          query=manager.createNamedQuery("DELETE_EMPS_BY_DESG");
          query.setParameter("job","CLERK");
          //execute the query
          count=query.executeUpdate();
	        flag=true;
		}//try
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("no.of records effected::"+count);
			 }
			 else {
				 tx.rollback();
				 System.out.println("records not found");
			 }
			manager.close();
			factory.close();
		}
	}//main
}//class
