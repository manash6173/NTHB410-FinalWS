package com.nt.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class PL_SQLNativeTest {

	public static void main(String[] args) {
		Session ses=null;
		ProcedureCall call=null;
		 List<Employee> list=null;
		 Output output=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//create ProcedureCall object
			call=ses.createStoredProcedureCall("p_get_emps_by_desg",Employee.class);
			//register IN,OUT params with JDBC types and bind values to IN params
			call.registerParameter(1, String.class, ParameterMode.IN).bindValue("sweeper");
			call.registerParameter(2,Employee.class,ParameterMode.REF_CURSOR);
			//get Output obj having by calling PL/SQL Procedure
			output=call.getOutputs().getCurrent();
			//get ResultList from Output obj
			list=((ResultSetOutput)output).getResultList();
			//process the result
			list.forEach(e->{
				System.out.println(e);
			});
			
			
		}//try
	 catch(Exception e) {
		 e.printStackTrace();
	 }
		finally {
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//
