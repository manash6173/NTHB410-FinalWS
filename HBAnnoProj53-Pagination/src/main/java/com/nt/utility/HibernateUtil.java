package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static  SessionFactory  factory=null;
	static {
		Configuration cfg=null;
		//create Configuration object
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//create SEssionfactiory obj
		factory=cfg.buildSessionFactory();
	}
	
	public  static    Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.getCurrentSession();
		return ses;
		
	}
	
	public  static  void  closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
