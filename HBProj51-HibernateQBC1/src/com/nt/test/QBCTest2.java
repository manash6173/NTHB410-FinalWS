package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Viechle;
import com.nt.utility.HibernateUtil;

public class QBCTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		Criterion  cond=null,cond1=null,cond2=null,andCond=null,orCond=null; 
		List<Viechle> list=null;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		//create Criteria object
		criteria=ses.createCriteria(Viechle.class);
		//perfor pagination
		criteria.setFirstResult(2);
		criteria.setMaxResults(2);
		//execute the QBC logic
		list=criteria.list();
		//proces the results
		list.forEach(v->{
			System.out.println(v);
		}); 
		
		
	   }//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
