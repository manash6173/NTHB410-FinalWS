package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Insurancepolicy;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Insurancepolicy> list=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//access Named HQL Query
		query=ses.getNamedQuery("HQL_GET_POLICIES_BY_TENURE");
		//get Access to Named HQL Query
		query.setParameter("min",200L);
		query.setParameter("max",250L);
		//execute query
		list=query.getResultList();
		//process the result
		list.forEach(ip->{
			System.out.println(ip);
		});
		
		//close Session,SessionFactory
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}
}
