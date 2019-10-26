package com.nt.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NativeSQLTest1 {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery query=null;
		List<Project> list1=null;
		List<Object[]> list2=null;
		List<Object> list3=null;
		boolean flag=false;
		Transaction tx=null;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		try {

        //mapping select query results with domain class
			//create SQLQuery object
		/*	query=ses.createSQLQuery("SELECT PROJID,PROJNAME,TEAMSIZE,STARTDATE,RELEASEDATE FROM PROJECT  WHERE TEAMSIZE>=?0 AND TEAMSIZE<=?1");
			//map query reuslts with domain class
			query.addEntity(Project.class);
			//set values to query params
			query.setParameter(0,3);
			query.setParameter(1, 10);
			//execute the query
			list1=query.getResultList();
			//process the results
			list1.forEach(p->{
				System.out.println(p);
			}); */
			
			//prepare native  SQL scalar query
		/*	query=ses.createSQLQuery("SELECT PROJID,PROJNAME FROM PROJECT");
			query.addScalar("PROJID",StandardBasicTypes.SHORT);
			query.addScalar("PROJNAME",StandardBasicTypes.STRING);
			list2=query.getResultList();
			list2.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" "+val.getClass());
				}
				System.out.println();
			}); */
		   //prepare  native SQL scalar query having aggragate results
	/*	   query=ses.createSQLQuery("select count(*) from Project");
		   query.addScalar("count(*)",StandardBasicTypes.INTEGER);
		   list3=query.getResultList();
		   System.out.println("Records count::"+list3.get(0)+"..."+list3.get(0).getClass()); */
			
			//prepare Native SQL non-select query
			query=ses.createSQLQuery("INSERT INTO PROJECT(PROJID,PROJNAME,RELEASEDATE) VALUES(?,?,?)");
			//set query param values
			query.setParameter(1,9001);
			query.setParameter(2,"OpenFx");
			query.setParameter(3,new Date(119,6,30));
			//begin Tx
			tx=ses.beginTransaction();
			 count=query.executeUpdate();
			flag=true;
		}//try
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("record inserted");
			}
			else {
				tx.rollback();
				System.out.println("record not inserted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		

	}//main
}//class
