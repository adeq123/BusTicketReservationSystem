package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDB {
    private DataBaseModel dbModel;
    public LoginDB(DataBaseModel dbModel) throws Exception{
	this.dbModel = dbModel;
	createLoginTable();
	addNewUser("admin", "admin");
    }
    /**
     * The method creates the Login table (user / pwd pairs) in the database if it doesn't exist.
     * used to login to Bus Managemet application
     * @throws Exception
     */
    public void createLoginTable() throws Exception{
	try{
	    Connection conn = dbModel.getConnectionToBusDataBase();
	    PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS logintable("
		    + "username varchar(255) NOT NULL, "
		    + "password varchar(255) NOT NULL, "
		    + "PRIMARY KEY(username))");


	    create.executeUpdate();
	}catch(Exception e){System.out.println(e);}
    }

    /**
     * The method adds login user / pwd pair as specified
     * @param user, String, username
     * @param password, String, password
     * @throws Exception
     */
    public void addNewUser(String username, String password) throws Exception{

	Connection conn = dbModel.getConnectionToBusDataBase();
	PreparedStatement create = conn.prepareStatement("INSERT IGNORE INTO logintable ("
		+ "username, "
		+ "password) "
		+ "values ( "
		+ "'" + username + "'," 
		+ "'" + password + "'" 
		+ ")"); 
	create.executeUpdate();
    }

    /**
     * Deletes user with a given username.
     * @param username, String, username of user to be deleted.
     * @throws Exception
     */
    public void deleteUser(String username) throws Exception{
	Connection conn = dbModel.getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("DELETE FROM logintable WHERE username=" + username);
	create.executeUpdate();
    }

    /**
     * Gets the ResultSet associated with a username pointed by username parameter
     * @param username
     * @return ResultSet, associated with a username pointed by username parameter
     * @throws Exception
     */
    public ResultSet getUser(String username) throws Exception{
	Connection conn = dbModel.getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("SELECT * FROM logintable WHERE username='" + username+"'");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    
/**
 * Returns whole administration table (user and password)
 * @return, ResultSet of all users and passwords
 * @throws Exception
 */
    public ResultSet getAdminTable() throws Exception{
	Connection conn = dbModel.getConnectionToBusDataBase(); //MAKE A FIELD ??
	PreparedStatement create = conn.prepareStatement("SELECT * FROM logintable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
}
