package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Insurancepolicy;
import com.nt.utility.HibernateUtil;

public class HQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Insurancepolicy> list=null;
		Iterator<Insurancepolicy> it=null;
		Iterator<Object[]> it1=null;
		Insurancepolicy policy=null;
		List<Object[]> list1=null;
		List<Integer> list2=null;
		List<Long> list3=null;
		//get Session
		ses=HibernateUtil.getSession();
		// crete Query object having HQL
	/*	query=ses.createQuery(" from Insurancepolicy ");
		//execute the query
		list=query.list();
		//process the Result
		list.forEach(ip->{
			System.out.println(ip+".."+ip.getClass());
		}); */ 

		/*while(it.hasNext()) {
		  policy=it.next();
		  System.out.println(policy+"..."+policy.getClass());
		  System.out.println("........");
		}*/
		
	/*	//prepare Query obj
		query=ses.createQuery("from Insurancepolicy where tenure>=?0 and tenure<=?1");
		//set values to query params
		query.setParameter(0,100L);
		query.setParameter(1,200L);
		//execute the Query
		list=query.getResultList();
		//process the Result
		list.forEach(ip->{
			System.out.println(ip);
		}); */
		
	/*	//prepare Query obj
		query=ses.createQuery(" from Insurancepolicy where tenure>=:min and tenure<=?0");
		//set values to query params
		query.setParameter("min",100L);
		query.setParameter(0,200L);
		//execute the Query
		list=query.getResultList();
		//process the Result
		list.forEach(ip->{
			System.out.println(ip);
		}); */
		
		//getting specific multiple col values...
		/*query=ses.createQuery("select policyid,policyname,initialamount from  Insurancepolicy where company=:comp");
		query.setParameter("comp","LIC"); */
		/*list1=query.getResultList();
		for(Object row[]:list1) {
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		}*/
		/*it1=query.iterate();
		while(it1.hasNext()) {
			Object row[]=it1.next();
			for(Object val:row) {
				System.out.print(val+" ");
			}//for
			System.out.println();
		}//for */
		
	/*	// getting specific single col value from DB table
		query=ses.createQuery("select policyid from Insurancepolicy where tenure>=:min and tenure<=:max");
		query.setParameter("min", 100L);
		query.setParameter("max",500L);
		list2=query.list();
		list2.forEach(id->{
			System.out.println(id);
		}); */
		
		//getting results using aggregator
	/*	query=ses.createQuery("select count(*) from Insurancepolicy");
		list3=query.list();
		System.out.println("records count::"+list3.get(0)+"--->"+list3.get(0).getClass()); */
		
       //get results using  sub query
		query=ses.createQuery("from Insurancepolicy where initialamount=(select max(initialamount) from Insurancepolicy)");
		list=query.getResultList();
		list.forEach(ip->{
			System.out.println(ip);
		});
		
		
		
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		

	}

}
