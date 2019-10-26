package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		//save data
		//dao.saveData();
		//dao.loadDataUsingParent();
		//dao.loadDataUsingParentByUserId(1);
		//dao.deleteDataUsingParentByUserId(1);
		//dao.deleleAllChildsOfAParentByUserId(2);
		dao.deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(3);
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
