package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class NITSequenceIdGenerator implements IdentifierGenerator {
  private static final String NIT_SEQ="SELECT NIT_SEQ.NEXTVAL FROM DUAL";
	@Override
	public Serializable generate(SharedSessionContractImplementor ses, Object object) throws HibernateException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int val=0;
		
	   try {
		 //get Connection obj from Sesion obj
		   con=ses.connection();
		 // create JDBC PreparedStatemen object  
		   ps=con.prepareStatement(NIT_SEQ);
		 // execute the Query
		   rs=ps.executeQuery();
		  //gather result 
		   if(rs.next()) {
			   val=rs.getInt(1);
		   }
           //generate the id value
		   if(val<=9)
			   return "NIT00"+val;
		   else if(val<=99)
			   return "NIT0"+val;
		   else
			   return "NIT"+val;
		   
	   }//try
	   catch(SQLException se) {
		   se.printStackTrace();
		   return "could not generate id value";
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   return "could not generate id value";
	   }
	   finally {
		   //close jdbc objs
		   try {
			   if(rs!=null)
				   rs.close();
		   }
		   catch(SQLException se) {
			   se.printStackTrace();
		   }
		   try {
			   if(ps!=null)
				   ps.close();
		   }
		   catch(SQLException se) {
			   se.printStackTrace();
		   }
		  
	   }//finally
	}//generate
}//class
