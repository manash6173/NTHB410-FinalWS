package com.nt.test;

import java.util.List;

import com.nt.dao.InsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOFactory;
import com.nt.utility.HibernateUtil;

public class PLSQLFunctionTest {

	public static void main(String[] args) {
		InsurancePolicyDAO dao=null;
		List<Object[]> list=null;
		//get DAO
		dao=InsurancePolicyDAOFactory.getInstance();
		
		//invoke the method
		list=dao.getPoliciesByCompany("LIC");
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
		
		//close session factory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
