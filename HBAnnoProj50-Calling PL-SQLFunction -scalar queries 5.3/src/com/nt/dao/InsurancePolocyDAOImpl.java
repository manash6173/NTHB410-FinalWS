package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;

import com.nt.utility.HibernateUtil;

import oracle.jdbc.OracleTypes;

public class InsurancePolocyDAOImpl implements InsurancePolicyDAO {

	@Override
	public List<Object[]> getPoliciesByCompany(String company) {
		Session ses=null;
		List<Object[]> list=null;
	    //get Session
		ses=HibernateUtil.getSession();
		try {
		 list=ses.doReturningWork(con->{
			 CallableStatement cs=null;
			 List<Object[]> list1=null;
			 ResultSet rs=null;
			//reate Callable STatement obj
			 cs=con.prepareCall("{?= call fx_get_policies_by_company(?)}");
			 System.out.println(cs.getClass());
			 //register Out parameter
			 cs.registerOutParameter(1, OracleTypes.CURSOR);
			 //set values to IN params
			 cs.setString(2,company);
			 //call PL/SQL function
			 cs.execute();
			 //get reuslt from return value
			 rs=(ResultSet)cs.getObject(1);
			 //copy Result records to List<Object[]>
			 list1=new ArrayList();
			 while(rs.next()) {
				 Object row[]=new Object[3];
				 row[0]=rs.getInt(1);
				 row[1]=rs.getString(2);
				 row[2]=rs.getInt(3);
				 list1.add(row);
			 }
			 
			return list1; 
		 });
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
		return list;
	}//method
}//class
