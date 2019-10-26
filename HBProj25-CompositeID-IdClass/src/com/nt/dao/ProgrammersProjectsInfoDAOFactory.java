package com.nt.dao;


public class ProgrammersProjectsInfoDAOFactory {
	public static  ProgrammersProjectsInfoDAO  getInstance() {
		return  new ProgrammersProjectsInfoDAOImpl();
	}

}
