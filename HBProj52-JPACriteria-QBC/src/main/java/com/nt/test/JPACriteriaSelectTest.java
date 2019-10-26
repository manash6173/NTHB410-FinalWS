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

public class JPACriteriaSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Viechle> ctQuery=null;
		Root<Viechle> root=null;
		Query query=null;
		List<Viechle> list=null;
		ParameterExpression<Integer> param1=null;
		ParameterExpression<Integer> param2=null;
		Predicate pdc1=null,pdc2=null,pdc3=null;
		Order order=null;
		
	 //get Session
		ses=HibernateUtil.getSession();
		try {
		 /*	//get CriteriaBuilder
			builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			ctQuery=builder.createQuery(Viechle.class);
		 	//create Root object
			root=ctQuery.from(Viechle.class);
			//Add root obj Criteria Query obj
			ctQuery.select(root);
			//Create Query obj having Criteria Query obj
			query=ses.createQuery(ctQuery);
			//execute JPA Criteria
			list=query.getResultList();
			//process the collection
			list.forEach(v->{
				System.out.println(v);
			}); */
			
			//create Criteriabuilder obj
			builder=ses.getCriteriaBuilder();
			//get CriteriaQuery obj
			ctQuery=builder.createQuery(Viechle.class);
			//create Root object
			root=ctQuery.from(Viechle.class);
			//add Root obj to Criteria obj
			ctQuery.select(root);
			//Define Parameter objs
			param1=builder.parameter(Integer.class);
			param2=builder.parameter(Integer.class);
			//Defined Predicate objs
			pdc1=builder.ge(root.get("vid"),param1);
			pdc2=builder.le(root.get("vid"),param2);
			pdc3=builder.and(pdc1,pdc2);
			//add Predicate obj
			ctQuery.where(pdc3);
			//get ORder obj
			order=builder.desc(root.get("model"));
			//add Order obj to Criteria obj
			ctQuery.orderBy(order);
			//create Query obj
			query=ses.createQuery(ctQuery);
			//set query param values
			query.setParameter(param1, 2000);
			query.setParameter(param2,3000 );
			//execute the logics
			list=query.getResultList();
			//process the results
			list.forEach(v->{
				System.out.println(v);
			});
			
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
