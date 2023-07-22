package com.sbank.connection;

import java.sql.*;
public class ConnectDB {
	

		static Connection done = null;
		public static Connection getConnect(){
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				done = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbankservlet", "root", "");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return done;
		}
	}

