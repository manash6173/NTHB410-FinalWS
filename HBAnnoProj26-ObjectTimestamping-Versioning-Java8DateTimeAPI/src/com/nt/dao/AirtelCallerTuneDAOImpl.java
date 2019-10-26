package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.AirtelCallerTune;
import com.nt.utility.HibernateUtil;

public class AirtelCallerTuneDAOImpl implements AirtelCallerTuneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		AirtelCallerTune tune=null;
		int idVal=0;
	   //get Session
		ses=HibernateUtil.getSession();
		//prepare object
		tune=new AirtelCallerTune();
		tune.setCustId(7810);
		tune.setCustName("ramesh");tune.setMobileNo(9999999999L);
		tune.setCallerTune("Dil pukare");
		try {
			tx=ses.beginTransaction();
			  idVal=(int) ses.save(tune);
			  System.out.println("id value::"+idVal);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		  }//finally
		}//method

	@Override
	public void loadAndModifyData() {
		Session ses=null;
		AirtelCallerTune tune=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//get Object
			tune=ses.get(AirtelCallerTune.class,7810);
			if(tune==null) {
				System.out.println("Record not found");
				return;
			}
			else {
			  tx=ses.beginTransaction();
			     tune.setCallerTune("pkk local");
			     ses.update(tune);
			  flag=true;
			}
		}//try
		catch(Exception e) {
			flag=false;
	        e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is  lastly updated at "+tune.getLastUpdated());
			}
			else {
				tx.rollback();
				System.out.println("Object is not upated");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		  }//finally
		}//method
}//class
