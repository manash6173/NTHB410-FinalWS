package com.nt.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
		Configuration cfg=null;
		//Bootstrap the hibernate
		cfg=new Configuration();
		
		//programatic
		cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username","system");
		cfg.setProperty("hibernate.connection.password","manager");
		cfg.setProperty("show_sql","true");
		cfg.setProperty("format_sql","true");
		cfg.setProperty("dialect","org.hibernate.dialect.Oracle10gDialect");
		//set Hibernate cfg properties
				cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//add mapping file
		cfg.addFile("src/com/nt/entity/Employee.hbm.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public  static  void   closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	public static void  closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
