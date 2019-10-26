package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface ReportDAO {
	public long getRecordsCount();
	public  List<Employee> getReportData(int statPos,int pageSize);

}
