package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFilterTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		NativeQuery query=null,query1=null,query3=null;
		List<BankAccount> list=null;
		List<Object> list1=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//enable Filter on Session obj
		filter=ses.enableFilter("FILTER_REMOVE_ACCOUNTS");
		//set values to Filter params
		filter.setParameter("type1","BLOCKED");
		filter.setParameter("type2","SUSPENDED");
		filter.setParameter("type3","CLOSED");
		//HQL->Prepare Query object
		query=ses.createSQLQuery("select * from  Bank_Account");
		query.addEntity(BankAccount.class);
		list=query.getResultList();
		list.forEach(acc->{
			System.out.println(acc);
		});
		//disable Filter
		ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
		query1=ses.createSQLQuery("select count(*) from  Bank_Account");
		query1.addScalar("count(*)",StandardBasicTypes.INTEGER);
		list1=query1.getResultList();
		System.out.println("Records count::"+list1.get(0));
		
		//begin  Transaction
		tx=ses.beginTransaction();
		  query3=ses.createSQLQuery("update Bank_Account set balance=balance+:bonus");
		  query3.setParameter("bonus",20.0f);
		  count=query3.executeUpdate();
		 flag=true;  
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" no.of records are updated");
			}
			else {
				tx.rollback();
				System.out.println("no records are found for updation");
			}
			//close Hibernate objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
