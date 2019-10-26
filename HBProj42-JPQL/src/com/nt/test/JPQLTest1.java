package com.nt.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.nt.entity.Employee;

public class JPQLTest1 {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		Query query=null;
		List<Employee> list=null;
		List<Object[]> list1=null;
		//get EntityManagerFactory
		factory=Persistence.createEntityManagerFactory("pu1");
		//crete EntityManager
		manager=factory.createEntityManager();
		try {
	/*	//create Query obj
			query=manager.createQuery("select * from Employee");
        //execute the query
	     list=query.getResultList();
	     //process the result
	     list.forEach(e->{
	    	 System.out.println(e);
	     }); 
	     list.stream().forEach((e)-> System.out.println(e)); */
		 
			//query=manager.createQuery("select eno,ename from Employee where salary>=?1 and salary<=?2");
			query=manager.createQuery("select eno,ename from Employee where salary>=:min and salary<=:max");
			query.setParameter("min",5000.0f);
			query.setParameter("max",10000.0f);
			list1=query.getResultList();
			list1.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			factory.close();
		}
	}//main
}//class
