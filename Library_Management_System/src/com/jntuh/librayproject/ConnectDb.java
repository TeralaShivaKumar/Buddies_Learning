package com.jntuh.librayproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb {
	 Connection con;
	 Statement st;
	public ConnectDb(){ 
		try {
			//Load JDBC Driver Class
			// Class.forName("com.mysql.cj.jdbc.Driver");
			 
			//Establish the Connection
			 con=DriverManager.getConnection("jdbc:mysql:///librarydatabase","root","root");
			 
			 //Create JDBC Statement Object
			 if(con!=null) {
				 st=con.createStatement();
			 }	 
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
				
	}

}
