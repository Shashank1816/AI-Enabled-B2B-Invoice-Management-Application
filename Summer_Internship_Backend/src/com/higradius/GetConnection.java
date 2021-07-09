package com.higradius;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/invoicedb";
	
	//DB credentials
	static final String USER = "root";
	static final String PASS = "sv8530";
	
	public static Connection connectToDB() throws Exception
	{
		// Register for JDBC Driver
		Class.forName(JDBC_DRIVER);
		// Open a Connection
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		return conn;
	}
	
}
