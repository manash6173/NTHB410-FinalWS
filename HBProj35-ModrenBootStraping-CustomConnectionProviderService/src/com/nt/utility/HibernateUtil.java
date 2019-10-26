package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import com.nt.service.DeveloperManagedConnectionProvider;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
		Configuration cfg=null;
		ServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		//Bootstrap the hibernate
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Create Registrybuilder
		builder=new ServiceRegistryBuilder().applySettings(cfg.getProperties());
		//put service in RegistryBuilder
		//builder.addService(ConnectionProvider.class,new DeveloperManagedConnectionProvider());
		//create SErviceRegistry
		registry=builder.buildServiceRegistry();
		//build SessionFactory
		factory=cfg.buildSessionFactory(registry);

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
