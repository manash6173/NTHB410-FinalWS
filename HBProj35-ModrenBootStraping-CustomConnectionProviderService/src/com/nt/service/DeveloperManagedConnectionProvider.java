package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.Startable;
import org.hibernate.service.spi.Stoppable;

public class DeveloperManagedConnectionProvider implements ConnectionProvider, Configurable, Stoppable, Startable {
   
	@Override
	public boolean isUnwrappableAs(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Map arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("DeveloperManagedConnectionProvider.closeConnection()");
		con.close();

	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("DeveloperManagedConnectionProvider:getConnection()");
		Connection con=null;
		try {
		  //register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
		   //establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
           return con;			
		}
		catch(Exception e) {
		   return null;
		}
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
