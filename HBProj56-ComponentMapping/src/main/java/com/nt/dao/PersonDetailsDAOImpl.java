package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.AddressDetails;
import com.nt.entity.PersonDetails;
import com.nt.utility.HibernateUtil;

public class PersonDetailsDAOImpl implements PersonDetailsDAO {

	@Override
	public void saveData() {
		Session ses=null;
		AddressDetails aDetails1=null,aDetails2=null;
		PersonDetails pDetails1=null,pDetails2=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
			
		  //prepare objects 	
			aDetails1=new AddressDetails();
			aDetails1.setHouseNo("1-2-200");
			aDetails1.setStreet("RKstreet");
			aDetails1.setArea("HYd");
			aDetails1.setPinCode(500060);

			pDetails1=new PersonDetails();
			pDetails1.setPname("RAVI");
			pDetails1.setAddrs(aDetails1);
			pDetails1.setAge((byte)26);
			
			aDetails2=new AddressDetails();
			aDetails2.setHouseNo("1-1-201");
			aDetails2.setStreet("SKstreet");
			aDetails2.setArea("HYd");
			aDetails2.setPinCode(500061);
			
			pDetails2=new PersonDetails();
			pDetails2.setPname("JANI");
			pDetails2.setAddrs(aDetails2);
			pDetails2.setAge((byte)36);
			tx=ses.beginTransaction();
			ses.save(pDetails1);
			ses.save(pDetails2);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			//close objs
			if(flag) {
				tx.commit();
				System.out.println("Object are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close objs
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadAllData() {
		Session ses=null;
		List<PersonDetails> list=null;
		Query query=null;
		try {
		//get Session
		ses=HibernateUtil.getSession();
		// create Query
		query=ses.createQuery("from PersonDetails");
		//exeute Query
		list=query.getResultList();
		//proess the Result
		list.forEach(pd->{
			System.out.println(pd);
		});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method

	@Override
	public void loadDataByStreet(String street) {
		Session ses=null;
		List<PersonDetails> list=null;
		Query query=null;
		try {
		//get Session
		ses=HibernateUtil.getSession();
		// create Query
		query=ses.createQuery("from PersonDetails where addrs.street=:galli");
		//set query param value
		query.setParameter("galli", street);
		//exeute Query
		list=query.getResultList();
		//proess the Result
		list.forEach(pd->{
			System.out.println(pd);
		});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
	}
	
	
	
}//class
