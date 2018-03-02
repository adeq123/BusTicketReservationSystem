package model;

/**
 * This class contains some basic calculations used in ticket and bus processing
 * @author ADRO
 *
 */
public class BusTicketCalculations {
    
    private static double farePerKilometer = 2; //$
   
    public static double getTicketPrice (double distance){
	return distance*farePerKilometer;
    }
}
