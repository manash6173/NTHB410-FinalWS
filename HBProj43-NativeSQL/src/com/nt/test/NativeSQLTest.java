package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		List<Object[]> list=null;
		List<Project> list1=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
	/*	//create SQLQuery object
		query=ses.createSQLQuery("SELECT PROJID,PROJNAME,TEAMSIZE,STARTDATE,RELEASEDATE FROM PROJECT");
		//execute the query
		list=query.getResultList();
		//process the results
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		}); */
        //mapping select query results with domain class
			//create SQLQuery object
			query=ses.createSQLQuery("SELECT PROJID,PROJNAME,TEAMSIZE,STARTDATE,RELEASEDATE FROM PROJECT");
			//map query reuslts with domain class
			query.addEntity(Project.class);
			//execute the query
			list1=query.getResultList();
			//process the results
			list1.forEach(p->{
				System.out.println(p);
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
