package com.nt.test;

import com.nt.dao.ProgrammersProjectsInfoDAO;
import com.nt.dao.ProgrammersProjectsInfoDAOFactory;
import com.nt.utility.HibernateUtil;

public class CompositeIdTest {

	public static void main(String[] args) {
		ProgrammersProjectsInfoDAO dao=null;
		//get DAO
		dao=ProgrammersProjectsInfoDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		dao.loadData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
