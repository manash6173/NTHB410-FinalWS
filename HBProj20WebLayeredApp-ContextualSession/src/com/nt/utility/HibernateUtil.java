package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static  SessionFactory factory;
	static {
		Configuration cfg=null;
		try {
		 //Boot strap Hibernate
			cfg=new Configuration();
		    cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		 //create SessionFactory
			factory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	//create Session obj on 1 per thread basis (one per related persitence operations)
	public   static  Session  getSession() {
	    Session ses=null;
	     if(factory!=null) {
	    	 ses=factory.getCurrentSession();
	     }
		return ses;
	}
	
	
	
	public  static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
 
}
