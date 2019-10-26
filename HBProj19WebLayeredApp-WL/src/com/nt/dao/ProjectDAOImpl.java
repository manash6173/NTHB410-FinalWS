package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public Project getProjectById(int pid) {
		Session ses=null,ses1=null;
		Project proj=null;
		//get Session
		ses=HibernateUtil.getSession();
		ses1=HibernateUtil.getSession();
		System.out.println(ses.hashCode()+"  "+ses1.hashCode());
		//Load object
		proj=ses.get(Project.class,pid);
		return proj;
		
	}

}
