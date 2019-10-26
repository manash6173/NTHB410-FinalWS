package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFilterTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Criteria criteria=null;
		Projection p1=null;
		List<BankAccount> list=null;
		List<Object> list1=null;
		
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//enable Filter on Session obj
		filter=ses.enableFilter("FILTER_REMOVE_ACCOUNTS");
		//set values to Filter params
		filter.setParameter("type1","BLOCKED");
		filter.setParameter("type2","SUSPENDED");
		filter.setParameter("type3","CLOSED");
		//HB QBC->Prepare Query object
		criteria=ses.createCriteria(BankAccount.class);
		list=criteria.list();
		list.forEach(acc->{
			System.out.println(acc);
		});
		//disable Filter
		ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
		//HB QBC->Prepare Query object
		criteria=ses.createCriteria(BankAccount.class);
		p1=Projections.rowCount();
		criteria.setProjection(p1);
		list1=criteria.list();
		System.out.println("records count::"+list1.get(0));
		
		
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close Hibernate objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
