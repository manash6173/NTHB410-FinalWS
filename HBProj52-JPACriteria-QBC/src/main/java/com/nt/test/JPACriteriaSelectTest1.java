package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nt.entity.Viechle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaSelectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Object[]> ctQuery=null;
		CriteriaQuery<Object> ctQuery1=null;
		Root<Viechle> root=null;
		Query query=null;
		Predicate pdc1=null;
		ParameterExpression<String> p1=null;
		List<Object[]> list=null;
		List<Object> list1=null;
		Object row[]=null;
		
	 //get Session
		ses=HibernateUtil.getSession();
		try {
			/*  // get CriteriaBuilder obj
				builder=ses.getCriteriaBuilder();
			  //create CriteriaQuery object
				ctQuery=builder.createQuery(Object[].class);
			  //create Root object
				root=ctQuery.from(Viechle.class);
			  // perform scalar operations
				ctQuery.multiselect(root.get("vid"),root.get("model"),root.get("company"));
			  //create ParmaeterExression obj	
				p1=builder.parameter(String.class);
			   //prepareCondition
				pdc1=builder.like(root.get("model"),p1);
				//add Predicate obj to CriteriaQuery
				ctQuery.where(pdc1);
				//prepare Query obj
				query=ses.createQuery(ctQuery);
				//set param values
				query.setParameter(p1,"a%" );
				//execute Query
				list=query.getResultList();
				//process the Result
				list.forEach(row->{
					for(Object val:row) {
						System.out.print(val+" ");
					}
					System.out.println();
				});
			*/	
			/*	 // get CriteriaBuilder obj
				builder=ses.getCriteriaBuilder();
			  //create CriteriaQuery object
				ctQuery1=builder.createQuery(Object.class);
			  // create Root obj
			root=ctQuery1.from(Viechle.class);
			  // perform scalar operations
			ctQuery1.multiselect(root.get("model"));
			   //create PameterExpression object
			p1=builder.parameter(String.class);
			   //prepare Condition
			pdc1=builder.equal(root.get("company"),p1);
			//add conditon obj CriteriaQuery
			ctQuery1.where(pdc1);
			//prepare Query obj
			query=ses.createQuery(ctQuery1);
			//set param value
			query.setParameter(p1,"honda");
			//execute QBC
			list1=query.getResultList();
			//process the Result
			list1.forEach(m->{
				System.out.println(m);
			});*/
			
			/*	 // get CriteriaBuilder obj
			builder=ses.getCriteriaBuilder();
			 //create CriteriaQuery object
			ctQuery1=builder.createQuery(Object.class);
			 // create Root obj
			root=ctQuery1.from(Viechle.class);
			// perform scalar opeation
			ctQuery1.multiselect(builder.count(root.get("vid")));
			//prepare Query obj
			query=ses.createQuery(ctQuery1);
			//execute QBC
			list1=query.getResultList();
			//process result
			System.out.println("records count::"+list1.get(0));*/
			
			 // get CriteriaBuilder obj
			builder=ses.getCriteriaBuilder();
			 //create CriteriaQuery object
			ctQuery=builder.createQuery(Object[].class);
			 // create Root obj
			root=ctQuery.from(Viechle.class);
			// Perform scalar opeations
			ctQuery.multiselect(builder.max(root.get("price")),
					            builder.min(root.get("price")),
					            builder.sum(root.get("price")),
					            builder.avg(root.get("price")));
			//prepare Query obj
			query=ses.createQuery(ctQuery);
			//exectue QBC
			list=query.getResultList();
			//process the Reuslt
			row=list.get(0);
			System.out.println("max of prices::"+row[0]);
			System.out.println("min of prices::"+row[1]);
			System.out.println("sum of prices::"+row[2]);
			System.out.println("avg of prices::"+row[3]);
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
