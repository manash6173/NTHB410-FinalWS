package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFilterTest3 {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<BankAccount> ctQuery=null;
		CriteriaQuery<Object> ctQuery1=null;
		Root root=null;
		Query query=null;
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
		//JPA QBC->Prepare Query object
		builder=ses.getCriteriaBuilder();
		ctQuery=builder.createQuery(BankAccount.class);
		root=ctQuery.from(BankAccount.class);
		ctQuery.select(root);
		query=ses.createQuery(ctQuery);
		list=query.getResultList();
		list.forEach(acc->{
			System.out.println(acc);
		});
		//disable Filter
		ses.disableFilter("FILTER_REMOVE_ACCOUNTS");
		ctQuery1=builder.createQuery(Object.class);
		root=ctQuery1.from(BankAccount.class);
		ctQuery1.multiselect(builder.count(root.get("acno")));
		query=ses.createQuery(ctQuery1);
		list1=query.getResultList();
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
