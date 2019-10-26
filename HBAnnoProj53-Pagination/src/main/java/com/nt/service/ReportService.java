package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface ReportService {
	public  long  pagesCount(int pageSize);
	public  List<EmployeeDTO>  fetchReportData(int pageNo,int pageSize);

}
