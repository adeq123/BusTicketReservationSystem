package controller;

import java.awt.EventQueue;

import viewer.GeneralView;
import viewer.Login;

/**
 * Runner object for the MVC bus management application
 * @author ADRO
 *
 */
public class ApplicationRunner {

    /**
     * Main starter method for entry point for the Java program.
     * @param args, unused
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Controller appController = new Controller();
		    appController.start();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});


    }

}
