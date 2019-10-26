package com.nt.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.utility.HibernateUtil;

public class GeneratorsTest2 {

	public static void main(String[] args) {
		SessionFactory factory=null;
		RequestThread t1=null,t2=null;
		
		//create Session Factory
		factory=new Configuration().configure("com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get Session 
		
		t1=new RequestThread(factory);
		t2=new RequestThread(factory);
		t1.start();
		t2.start();
		
		//HibernateUtil.closeSessionFactory();
	}
}//class
