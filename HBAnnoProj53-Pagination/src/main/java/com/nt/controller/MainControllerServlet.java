package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.ReportService;
import com.nt.service.ReportServiceImpl;
import com.nt.dto.EmployeeDTO;

@WebServlet(value="/controller",loadOnStartup=1)
public class MainControllerServlet extends HttpServlet {
    ReportService service=null;
    int pageSize;
	public void init() {
		service=new ReportServiceImpl();
	}

	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String pageNo=null;
		int pNo=0;
		List<EmployeeDTO> listDTO=null;
		long pagesCount=0;
		RequestDispatcher rd=null;
	   //read form data , addtional req param value
		pageNo=req.getParameter("pageNo");
		if(pageNo==null) {		
			   pageSize=Integer.parseInt(req.getParameter("pageSize"));
			   pNo=1;
		}
		else
			pNo=Integer.parseInt(pageNo);
		
        
		//use Service
		listDTO=service.fetchReportData(pNo, pageSize);
		pagesCount=service.pagesCount(pageSize);
		//keep results in request scope
		req.setAttribute("reportData",listDTO);
		req.setAttribute("pagesCount",pagesCount);
		//forward to result page
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	public void destroy() {
		service=null;
	}

}
