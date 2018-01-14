package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseModel {

    public Connection getConnectionToBusDataBase() throws Exception{
	try{
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/busticketreservationsystem";
	String user = "root";
	String password = "";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, user, password);
	System.out.println("Connected");
	return conn;
	}catch(SQLException e){
	    System.out.println("SQLException: " + e.getMessage());
	    System.out.println("SQLState: " + e.getSQLState());
	    System.out.println("Vendor Error: " + e.getErrorCode());
	    return null;
	}
    }
}
