//Performs CRUD operation on all users
package com.dit.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dit.chatapp.dto.userDTO;
import com.dit.chatapp.utils.Encryption;


public class userDAO {
	
	public boolean isLogin(userDTO userdto) throws SQLException, ClassNotFoundException, Exception {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		final String SQL = "select userID from users where userID=? and password=?";
		try {
			con = CommonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userdto.getUserid());
			String encryptedPwd = Encryption.passwordEncrypt(new String(userdto.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs = pstmt.executeQuery();
			/*
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
			*/
			return rs.next();
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	//output=1, user is added
	//output=0, user is not added
	/*
	public int add(String userid, String password, byte age, String city, String phone, String email, String country, String state, String areaCode, String stdCode) {
		as this function will become complex with so many arguments in future, so we will not use this
	}
	*/ 
	//Solution:
	//wrap all these arguments in a class and make the object of this class
	public int add(userDTO userdto) throws ClassNotFoundException, SQLException, Exception {
		System.out.println("Received "+userdto.getUserid()+" "+userdto.getPassword());
		//Step - 1:Connection
		Connection connection = null;
		Statement stmt = null; //query
		try { //guarded region
			//establish connection
			connection = CommonDAO.createConnection();
			//Step - 2:Query
			stmt = connection.createStatement();
			//insert into users (userID, password) values('Ram', 'ram@123');
			int record = stmt.executeUpdate("Insert into users(userID, password) values('"+userdto.getUserid()+"','"+Encryption.passwordEncrypt(new String(userdto.getPassword()))+"')");
			return record;
		}
		finally { //will always get executed (resource clean)
			if(stmt != null) {
				stmt.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
}
