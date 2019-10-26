package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Viechle;
import com.nt.utility.HibernateUtil;

public class QBCTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null,p2=null,p3=null,p4;
		ProjectionList pList=null;
		List<Object[]> list=null;
		List<?> list1=null;
		Criterion cond=null;
		Order order=null;
		Object row[]=null;
		
		
		try {
		//get Session 
		ses=HibernateUtil.getSession();
	/*	//create Criteria object
		criteria=ses.createCriteria(Viechle.class);
		//prepare conditions
		cond=Restrictions.ge("vid",2000);
		//prepare Projections on cols../properties
		p1=Projections.property("vid");
		p2=Projections.property("company");
		p3=Projections.property("model");
		//add multiple Projections to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1);pList.add(p2); pList.add(p3);
		//create Order object
		order=Order.desc("company");
		//add ProjectList obj to Criteria 
		criteria.setProjection(pList);
		//add Criterion obj
		criteria.add(cond);
		//add Order obj
		criteria.addOrder(order);
		//execute QBC
		list=criteria.list();
		//process result
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		}); */
		
			/*	//create Criteria obj
				criteria=ses.createCriteria(Viechle.class);
				//create Projection object
				p1=Projections.property("model");
				//add Projection obj to criteria object
				criteria.setProjection(p1);
				//execute QBC
				list1=criteria.list();
				//process the result
				list1.forEach(m->{
					System.out.println(m);
				});
			*/	
			/*//create Criteria object
			criteria=ses.createCriteria(Viechle.class);
			//Create Projection object
			p1=Projections.rowCount();
			//add Projection to Criteria
			criteria.setProjection(p1);
			//process the result
			list1=criteria.list();
			System.out.println("row count::"+list1.get(0));*/
		//create Criteria object
		  criteria=ses.createCriteria(Viechle.class);
		 //create Projections
		  p1=Projections.max("price");
		  p2=Projections.min("price");
		  p3=Projections.avg("price");
		  p4=Projections.sum("price");
		  //add Projections to ProjectionList
		  pList=Projections.projectionList();
		  pList.add(p1); pList.add(p2); pList.add(p3);pList.add(p4);
		  //add ProjectionList to Criteria object
		  criteria.setProjection(pList);
		  //execute QBC
		  list=criteria.list();
		  row=list.get(0);
		  System.out.println("max price value::"+row[0]);
		  System.out.println("min price value::"+row[1]);
		  System.out.println("avg price value ::"+row[2]);
		  System.out.println("sum price vlaue::"+row[3]);
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
