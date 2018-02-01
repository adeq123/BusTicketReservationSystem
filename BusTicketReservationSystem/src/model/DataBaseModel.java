package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseModel {

    private Connection getConnectionToBusDataBase() throws Exception{
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
    public void createBusTimeTable() throws Exception{
	try{
	   Connection conn = getConnectionToBusDataBase();
	   PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS busTimeTable("
	   	+ "busId int NOT NULL, "
	   	+ "busName varchar(255), "
	   	+ "busType varchar(255), "
	   	+ "seatsOccupied varchar(255), "
	   	+ "source varchar(255), "
	   	+ "timingSource TIME(0), "
	   	+ "destination varchar(255), "
	   	+ "timingDestination TIME(0), "
	   	+ "distance float NOT NULL, "
	   	+ "PRIMARY KEY(busId))");
	   
	   
	   create.executeUpdate();
	}catch(Exception e){System.out.println(e);}
    }
    
    public void createTicketTable() throws Exception{
	try{
	   Connection conn = getConnectionToBusDataBase();
	   PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ticketTable("
	   	+ "ticketNumber int NOT NULL AUTO_INCREMENT, "
	   	+ "source varchar(255), "
	   	+ "destination varchar(255), "
	   	+ "date DATE, "
	   	+ "timing TIME(0), "
	   	+ "distance float NOT NULL, "
	   	+ "cost float NOT NULL, "
	   	+ "busId int NOT NULL, "

	   	+ "seat int NOT NULL, "
	   	+ "passengerName varchar(255), "
	   	+ "mobile varchar(255), "
	   	+ "email varchar(255), "
	   	
	   	+ "PRIMARY KEY(ticketNumber))");
	   
	   
	   create.executeUpdate();
	}catch(Exception e){System.out.println(e);}
    }
    
    public void insertNewBus(int busId, String busName, String busType, String seatsOccupied, 
	    String source, String timing, String destination, String timingDestination, double distance) throws Exception{
	
	   Connection conn = getConnectionToBusDataBase();
	   
	   PreparedStatement create = conn.prepareStatement("INSERT INTO busTimeTable ("
		   + "busId, "
		   + "busName, "
		   + "busType, "
		   + "seatsOccupied, "
		   + "source, "
		   + "timingSource, "
		   + "destination, "
		   + "timingDestination, "
		   + "distance) "
		   + "values ( "
		   	+ "'" + busId + "'," 
		   	+ "'" + busName + "'," 
		   	+ "'" + busType + "',"
		   	+ "'" + seatsOccupied + "',"
		   	+ "'" + source + "',"
		   	+ "'" + timing + "',"
		   	+ "'" + destination + "',"
		   	+ "'" + timingDestination + "',"
		   	+ "'" + distance + "'" 
		   	+ ")"); 
	   
	   
	   create.executeUpdate();
    }
}
