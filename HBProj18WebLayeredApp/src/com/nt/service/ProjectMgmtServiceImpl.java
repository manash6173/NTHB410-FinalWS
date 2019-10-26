package com.nt.service;

import com.nt.dao.ProjectDAO;
import com.nt.dao.ProjectDAOImpl;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;

public class ProjectMgmtServiceImpl implements ProjectMgmtService {
    private ProjectDAO dao;
	public ProjectMgmtServiceImpl() {
		dao=new ProjectDAOImpl();
	}
	
	@Override
	public ProjectDTO searchProjectById(int pid) {
		Project proj=null;
		ProjectDTO dto=null;
		//use DAO
		proj=dao.getProjectById(pid);
		//convert  Project to ProjectDTO
		if(proj!=null) {
			System.out.println("from service class...");
		dto=new ProjectDTO();
		dto.setProjId(proj.getProjId());
		dto.setProjName(proj.getProjName());
		dto.setTeamSize(proj.getTeamSize());
		dto.setDomain(proj.getDomain());
		dto.setSdp(proj.getSdp());
		dto.setEdcp(proj.getEdcp());
		}
		return dto;
	}

}
