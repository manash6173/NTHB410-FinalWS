package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Viechle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaUpdateTest {

	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaUpdate<Viechle> ctUpdate=null;
		Root<Viechle> root=null;
		Predicate pdc1=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//create CriteriaBuilder obj
			builder=ses.getCriteriaBuilder();
			//get CriteriaUpdate object
			ctUpdate=builder.createCriteriaUpdate(Viechle.class);
			// create Root obj
			root=ctUpdate.from(Viechle.class);
			//update the col values
			ctUpdate.set("price",90000);
			//create Predicate object
			pdc1=builder.equal(root.get("model"),"activa");
			//add PRedicate object
			ctUpdate.where(pdc1);
			//create Query
			query=ses.createQuery(ctUpdate);
			//set param values
			//execute the QBC logic
			tx=ses.beginTransaction();
			  count=query.executeUpdate();
			flag=true;
		}//try
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" no.of records updated");
			}
			else {
				tx.rollback();
				System.out.println("records not found to update");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
