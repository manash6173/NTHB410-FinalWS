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

public class QBCTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		Criterion  cond=null,cond1=null,cond2=null,andCond=null,orCond=null; 
		List<Viechle> list=null;
		try {
		//get Session 
		ses=HibernateUtil.getSession();
		/*//create Criteria object
		criteria=ses.createCriteria(Viechle.class);
		//create Criterion object
		cond=Restrictions.between("vid",1000, 2000);
		//add Criterion obj to Criteria obj
		criteria.add(cond);
		//execute the QBC logic
		list=criteria.list();
		//proces the results
		list.forEach(v->{
			System.out.println(v);
		}); */
		
	/*	//create Criteria object
		criteria=ses.createCriteria(Viechle.class);
		//create Criterion object
		cond=Restrictions.in("company","bajaj","lml","honda");
		cond1=Restrictions.ilike("type","four-wheeler");
		cond2=Restrictions.between("price",100000.0f,2000000.0f);
		andCond=Restrictions.and(cond,cond1);
		orCond=Restrictions.or(andCond,cond2);
		//add Criterion obj to Criteria obj
		criteria.add(orCond);
		
		//execute the QBC logic
		list=criteria.list();
		//proces the results
		list.forEach(v->{
				System.out.println(v);
			}); */
		//create Criteria object
		criteria=ses.createCriteria(Viechle.class);
		//prepare Criterion object
		cond=Restrictions.sqlRestriction("rownum>=1 and rownum<=3");
		//prepare Order object
		Order ord=Order.desc("company");
		//add criteria obj
		criteria.add(cond);
		//add Order obj
    	criteria.addOrder(ord);
		
		//execute QBC
		list=criteria.list();
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
