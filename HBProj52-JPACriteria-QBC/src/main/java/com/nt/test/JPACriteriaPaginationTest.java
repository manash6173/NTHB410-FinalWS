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

public class JPACriteriaPaginationTest {

	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaQuery<Viechle> ctQuery=null;
		Root<Viechle> root=null;
		Query query=null;
		List<Viechle> list=null;
		
		
	 //get Session
		ses=HibernateUtil.getSession();
		try {
		 	//get CriteriaBuilder
			builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			ctQuery=builder.createQuery(Viechle.class);
		 	//create Root object
			root=ctQuery.from(Viechle.class);
			//Add root obj Criteria Query obj
			ctQuery.select(root);
			//Create Query obj having Criteria Query obj
			query=ses.createQuery(ctQuery);
			//pagination
			query.setFirstResult(0);
			query.setMaxResults(2);
			//execute JPA Criteria
			list=query.getResultList();
			//process the collection
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
