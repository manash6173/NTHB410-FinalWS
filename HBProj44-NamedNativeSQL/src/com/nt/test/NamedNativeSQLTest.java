package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery query=null;
		List<Project> list=null;
		List<Object[]> list1=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
	/*	  //get Access to NamedNative SQL Query
			query=ses.getNamedNativeQuery("GET_PROJS_BY_TEAMSIZE");
		// set query param values
			query.setParameter("min",3);
			query.setParameter("max",10);
        //execute query
			list=query.getResultList();
			list.forEach(e->{
				System.out.println(e);
			}); */
		 //get access to NamedNative SQL Query
			query=ses.getNamedNativeQuery("GET_RPOJS_BY_PROJIDS_RANGE");
		 //set query param values
			query.setParameter("min",1000);
			query.setParameter("max",1003);
          //execute the query
			list1=query.getResultList();
		   //process the result
			list1.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
			
			
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		

	}

}
