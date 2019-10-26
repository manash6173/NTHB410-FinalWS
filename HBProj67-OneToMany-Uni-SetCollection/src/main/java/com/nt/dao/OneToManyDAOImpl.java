package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> phonesSet=null;
		PhoneNumber ph1=null,ph2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare paren to child objs
		 //create Parent obj
			user=new User();
			user.setUname("raja");
			user.setAddrs("hyd");
		 //create child objs
			ph1=new PhoneNumber();
			ph1.setPhone(9977777777L);
			ph1.setNumberType("office");
			ph1.setProvider("airtel");
			
			ph2=new PhoneNumber();
			ph2.setPhone(8866666666L);
			ph2.setNumberType("personal");
			ph2.setProvider("vodafone");
		  //add child objs to parent obj
			phonesSet=new HashSet();
			phonesSet.add(ph1);
			phonesSet.add(ph2);
			user.setPhones(phonesSet);
			try {
			  //begin Tx
				tx=ses.beginTransaction();
				 ses.save(user);
				 flag=true;
			}//try
			catch(HibernateException he) {
				flag=false;
				he.printStackTrace();
			}
			catch(Exception e) {
				flag=false;
				e.printStackTrace();
			}
			finally {
				if(flag) {
					tx.commit();
					System.out.println("Parent to child objs are saved");
				}
				else {
					tx.rollback();
					System.out.println("Parent to child objs are not saved");
				}
				//close objs
				HibernateUtil.closeSession(ses);
			}//finally

  	}//saveData
	
	@Override
	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		  query=ses.createQuery("from User");
		  list=query.list();
		  list.forEach(user->{
			  System.out.println("parent::"+user);
				Set<PhoneNumber> childs=user.getPhones();
				System.out.println("childs count::"+childs.size());
			/*	 childs.forEach(ph->{
				  System.out.println("Child::"+ph);
				 }); */
		  });
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
	}//loadData
	
	@Override
	public void loadDataUsingParentByUserId(int userId) {
		Session ses=null;
		Query query=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
		  //query=ses.createQuery("from User where userId=:id");
			query=ses.createQuery("from User");
		  //query.setParameter("id",userId);
		 Stream<User> stream=
				 query.getResultStream().filter(user->((User)user).getUserId()==1);
		 
		 stream.forEach(user->{
			 System.out.println("parent--->"+user);
			 Set<PhoneNumber> childs=user.getPhones();
			 Stream chStream=childs.stream();
			 chStream.forEach(ph->{
				 System.out.println("child--->"+ph);
			 });
		 });
		  
		 
		 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		
	}//method
	
	
	@Override
	public void deleteDataUsingParentByUserId(int userId) {
		
		Query query=null;
		List<User> list=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		Session ses=HibernateUtil.getSession();
		try {
		//preare Query
		query=ses.createQuery("from User where userId=:id");
		query.setParameter("id",userId);
		list=query.list();
		 tx=ses.beginTransaction();
		   list.forEach(user->{
			   ses.delete(user);
		   });
		   flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("parent to child obj are deleted");
			}
			else {
				tx.rollback();
				System.out.println("parent to child obj are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void deleleAllChildsOfAParentByUserId(int userId) {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
		ses=HibernateUtil.getSession();
		//Load parent
		user=ses.get(User.class,userId);
		//get Childs of parent
		childs=user.getPhones();
		try {
		  tx=ses.beginTransaction();
		  childs.clear();
      	  flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("All Childs of a Parent  are deleted");
			}
			else {
				tx.rollback();
				System.out.println("All Childs of a Parent  are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(int userId) {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph1=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
		ses=HibernateUtil.getSession();
		//Load parent
		user=ses.get(User.class,userId);
		//get Childs of parent
		childs=user.getPhones();
		//Load Specific Load that u want to delete
		ph1=ses.get(PhoneNumber.class,9977777777L);
		try {
			tx=ses.beginTransaction();
			  childs.remove(ph1);
	 	    flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("One child from collection of chils are deleted");
			}
			else {
				tx.rollback();
				System.out.println("One child from collection of chils are not deleted");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
}//class
