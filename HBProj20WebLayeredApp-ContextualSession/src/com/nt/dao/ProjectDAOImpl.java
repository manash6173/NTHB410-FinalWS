package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public Project getProjectById(int pid) {
		Session ses=null,ses1=null;
		Project proj=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		tx=ses.beginTransaction();
		ses1=HibernateUtil.getSession();
		System.out.println(ses.hashCode()+"  "+ses1.hashCode());
		//Load object
		proj=ses.get(Project.class,pid);
		//proj=ses.load(Project.class,pid);
		return proj;
		
	}

}
