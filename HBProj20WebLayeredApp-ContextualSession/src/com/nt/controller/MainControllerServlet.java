package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectMgmtService;
import com.nt.service.ProjectMgmtServiceImpl;

public class MainControllerServlet extends HttpServlet {
	 private  ProjectMgmtService service=null;
	
	@Override
	public void init() throws ServletException {
	   service=new ProjectMgmtServiceImpl();
	}
	
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      int pid=0;
	      ProjectDTO dto=null;
	      RequestDispatcher rd=null;
	      
		 //read form data
	      pid=Integer.parseInt(req.getParameter("projId"));
	      //use service
	      dto=service.searchProjectById(pid);
	      //keep in request scope
	      req.setAttribute("pDetails",dto);
	      //forward to result.jsp
	      rd=req.getRequestDispatcher("/result.jsp");
	      rd.forward(req,res);
	}//doGet(-,-)
	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
	 
	 @Override
	public void destroy() {
	   service=null;
	}

}
