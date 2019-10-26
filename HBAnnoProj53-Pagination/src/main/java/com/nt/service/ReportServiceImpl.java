package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.ReportDAO;
import com.nt.dao.ReportDAOImpl;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

public class ReportServiceImpl implements ReportService {
   private ReportDAO dao;
	public ReportServiceImpl() {
		dao=new ReportDAOImpl();
	}
	
	@Override
	public long pagesCount(int pageSize) {
		long pagesCount=0;
		long recordsCount=0;
		//use DAO
		recordsCount=dao.getRecordsCount();
		//get pagesCount
		pagesCount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0)
			pagesCount++;
		
		return pagesCount;
	}

	@Override
	public List<EmployeeDTO> fetchReportData(int pageNo, int pageSize) {
		List<Employee> list=null;
		int startPos=0;
		List<EmployeeDTO> listDTO=new ArrayList();
		//get Start Position
		startPos=(pageNo*pageSize)-pageSize;
		//use DAO
		list=dao.getReportData(startPos,pageSize);
		//convert list Domain objs to list DTO class objs
		list.forEach(emp->{
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEno(emp.getEno());
			dto.setEname(emp.getEname());
			dto.setDesg(emp.getDesg());
			dto.setSalary(emp.getSalary());
			listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class
