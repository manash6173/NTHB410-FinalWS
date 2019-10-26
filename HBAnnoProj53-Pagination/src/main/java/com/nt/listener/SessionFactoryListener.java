package com.nt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class SessionFactoryListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
			Class.forName("com.nt.utility.HibernateUtil");
			System.out.println("Hiberante BootStrapped");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Hibernate is deactivated");
		HibernateUtil.closeSessionFactory();
		
	}
	
}
