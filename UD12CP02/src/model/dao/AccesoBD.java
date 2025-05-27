package model.dao;

import java.sql.*;

public class AccesoBD {
	
	public static Connection conn;
	
	public static Connection conectarBD() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca_municipal?"
				+ "useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","usuario","Cesur2425!");
		return conn;
	}
	
	public static void cerrarBD() throws SQLException{
		conn.close();
	}
	
	public static ResultSet consultaBD(String sql) throws SQLException{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		return rs;
	}
	
	public static int actualizaBD(String sql) throws SQLException{
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		return i;
	}
	
}
