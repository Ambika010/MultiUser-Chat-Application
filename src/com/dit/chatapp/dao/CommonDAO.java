package com.dit.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.dit.chatapp.utils.ConfigReader.getValue;

//interface bcs if ye clas hoga toh baar baar object create karni hogi alag alag jagah pe toh unwanted memory use hogi 
public interface CommonDAO {
	//interface allwos only static method
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// Step - 1 : Load a Driver
		Class.forName(getValue("DRIVER"));
		// Step - 2 : Making a connection
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USER_ID");
		final String PASSWORD = getValue("PASSWORD");
		Connection con = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		if(con != null) {
			System.out.println("Connection Established.....");
			//con.close();
		}
		return con;
	}
	/* (just for testing)
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CommonDAO cd = new CommonDAO();
		cd.createConnection();
	}
	*/
}
