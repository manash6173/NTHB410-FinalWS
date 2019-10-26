package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Viechle;
import com.nt.utility.HibernateUtil;

public class JPACriteriaDeleteTest {

	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		CriteriaDelete<Viechle> ctDelete=null;
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
			ctDelete=builder.createCriteriaDelete(Viechle.class);
			// create Root obj
			root=ctDelete.from(Viechle.class);
			//create Predicate object
			pdc1=builder.ge(root.get("price"),1000000);
			//add PRedicate object
			ctDelete.where(pdc1);
			//create Query
			query=ses.createQuery(ctDelete);
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
				System.out.println(count+" no.of records are deleted");
			}
			else {
				tx.rollback();
				System.out.println("records not found to delete");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
