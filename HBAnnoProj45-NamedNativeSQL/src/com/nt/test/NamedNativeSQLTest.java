package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery query1=null,query2=null;
		List<Project> list=null;
		int count=0;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 //get Access to Named Native SQL Query
		 query1=ses.getNamedNativeQuery("GET_PROJS_BY_IDS");
		 //set param values
		 query1.setParameter("min",1000);
		 query1.setParameter("max",2000);
		 //execute the query
		 list=query1.getResultList();
		 //proces the result
		 list.forEach(e->{
			 System.out.println(e);
		 });
		 //begin Tx
		 tx=ses.beginTransaction();
		   //get access named native SQL query
		 query2=ses.getNamedNativeQuery("UPDATE_PROJS");
		 count=query2.executeUpdate();
		 flag=true;
		}//try
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			//Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Tx committed");
			}
			else {
				tx.rollback();
				System.out.println("Tx is rolleback");
			}
				
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
