package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammersProjectsInfo;
import com.nt.utility.HibernateUtil;

public class ProgrammersProjectsInfoDAOImpl implements ProgrammersProjectsInfoDAO {

	@Override
	public void saveData() {
		Session ses=null;
		PrgmrProjId id=null,idVal=null;
		ProgrammersProjectsInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session 
		ses=HibernateUtil.getSession();
		//prpeare objects
		id=new PrgmrProjId();
		id.setPrgmrId(103); id.setProjId(1002);
		info=new ProgrammersProjectsInfo();
		info.setId(id);info.setPrgmrName("ramesh");
		info.setProjName("proj2");info.setSalary(90000);
		
		try {
		 tx=ses.beginTransaction();
		 idVal=(PrgmrProjId) ses.save(info);
		 System.out.println("Id value::"+idVal);
		 flag=true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objet is saved");
			}
			else {
				tx.rollback();
				System.out.println("Objet is not saved");	
			}
			//close SEssion
			HibernateUtil.closeSession(ses);
		}//finally

	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		PrgmrProjId id=null;
		ProgrammersProjectsInfo info=null;
		
		
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare id value for IdClass object
		id=new PrgmrProjId();
		id.setPrgmrId(103); id.setProjId(1002);
		try {
		//Load object
		info=ses.get(ProgrammersProjectsInfo.class, id);
		 if(info==null) {
			 System.out.println("record not found");
			 return;
		 }
		 else {
     		System.out.println(info);
		 }
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method

}//class
