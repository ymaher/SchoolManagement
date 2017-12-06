package com.lovecoding.dao;

import com.lovecoding.model.Login;
import java.sql.*;

public class LoginDao {

	public Login getLogin(String userName) {
		Login l = new Login();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management","school","school");
			Statement st = con.createStatement();
		ResultSet rs= st.executeQuery("select * from login where uname= '"+userName + "'");
		if(rs.next()) {
			l.setUserName(rs.getString("uname"));
			l.setPassword(rs.getString("password"));
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return l;
	}

	

	
}
