package com.nt.test;

import com.nt.dao.PaymentDAO;
import com.nt.dao.PaymentDAOFactory;
import com.nt.utility.HibernateUtil;

public class InhMappingTest {

	public static void main(String[] args) {
		PaymentDAO dao=null;
		//get DAO
		dao=PaymentDAOFactory.getInstance();
		//save data
		 //dao.saveData();
		//Load data
		  dao.loadData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();

	}

}
