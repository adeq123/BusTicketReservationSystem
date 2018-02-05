package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * This class models connection to sql data base all necessary interaction with database. Including inserting, updating, retrieving information from it. 
 * And creation of the tables.
 * @author ADRO
 */
public class DataBaseModel {

    /**
     * This method is taking care of connection to our databse.
     * @return, Connection, object used to communicate with bus management data base
     * @throws Exception
     */
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

    /**
     * The method creates the Bus Time Table in the database if it doesn't exist.
     * used to Bus management in the database
     * @throws Exception
     */
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

    /**
     * The method creates the Ticket table in the database if it doesn't exist.
     * used to Ticket management in the application
     * @throws Exception
     */
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

    /**
     * The method adds new bus to the databse with parameters specified
     * 
     * @param busId, int, Id of the bus
     * @param busName, String, name of the bus
     * @param busType, String, bus type @see GeneralView to see allowed bus types
     * @param seatsOccupied, String, list of seats occupied
     * @param source, String, origin city of the bus
     * @param timing, String, leaving time
     * @param destination, String, destination city
     * @param timingDestination, String, arrival time 
     * @param distance, double, distance of the time
     * @throws Exception
     */
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
	/*handle unique ID error*/
    }

    /**
     * The method returns the result set of entire table
     * @return, ResultSet, result set of entire table
     * @throws Exception
     */
    public ResultSet getBusTimeTable() throws Exception{
	Connection conn = getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("SELECT * FROM busTimeTable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    /**
     * The method returns busId column
     * @return, ResultSet, busId column
     * @throws Exception
     */
    public ResultSet getAllBusID() throws Exception{
	Connection conn = getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("SELECT busId FROM busTimeTable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    
    public void deleteBusWithID(int id) throws Exception{
	Connection conn = getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("DELETE FROM bustimetable WHERE busId=" + Integer.toString(id));
	create.executeUpdate();
    }
    
    public void updateBusRecord(int busId, String busName, String busType, String seatsOccupied, 
	    String source, String timing, String destination, String timingDestination, double distance) throws Exception{
	Connection conn = getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("UPDATE bustimetable SET "
		+ "busName = ?,"
		+ "busType = ?,"
		+ "seatsOccupied = ?,"
		+ "source = ?,"
		+ "timingSource = ?,"
		+ "destination = ?,"
		+ "timingDestination = ?,"
		+ "distance = ? "
		+ "WHERE busId = ?");
	create.setString(1, busName);
	create.setString(2, busType);
	create.setString(3, seatsOccupied);
	create.setString(4, source);
	create.setString(5, timing);
	create.setString(6, destination);
	create.setString(7, timingDestination);
	create.setString(8, Double.toString(distance));
	create.setString(9, Integer.toString(busId));
	create.executeUpdate();
    }
}
