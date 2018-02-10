package viewer;

import java.awt.Component;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * This interface models layout of general bus
 * @author ADRO
 *
 */

public abstract class BusLayout extends JPanel{

    /**
     * Loads the list of seats marks them as occupied and disables.
     * @param seatsList, String, list of occupied seats in format 1;2;3;12;16 ......
     */
    public void loadOccupiedSeats(String seatsList) {
	String [] seatsArray = seatsList.split(";");
	for (String seat : seatsArray){
	    disableSeat("seat" + seat);
	}
    }

    /**
     * This method returns all seats, modeled as JToggleButton, on the layout
     * @return, LinkedList<JToggleButton>, a list of seats
     */
    public LinkedList<JToggleButton> getAllSeatButtons(){
	LinkedList<JToggleButton> seatButtons = new LinkedList<JToggleButton>();
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seatButtons.add((JToggleButton)comp[i]);
	    }
	}
	return seatButtons;

    }
    /**
     * This method returns one seat pointed by seatName
     * @param seatName, a name of desired seat
     * @return, desired seat pointed by seatName
     */
    public JToggleButton getSelectedSeat(String seatName){
	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    return (JToggleButton)comp[i];
		}
	    }
	}
	return null;

    }

    /**
     * The method disables seat (represented by JToggleButton) pointed by seatName. 
     * And makes it pressed.
     * @param seatName, name of the seat to be disabled
     */
    public void disableSeat(String seatName){

	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    seat.setSelected(true);
		    seat.setEnabled(false);
		}
	    }
	}
    }

    /**
     * The method enables seat (represented by JToggleButton) pointed by seatName
     * @param seatName, name of the seat to be disabled
     */
    public void enableSeat(String seatName){

	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    seat.setSelected(false);
		    seat.setEnabled(true);
		}
	    }
	}
    }

    /**
     * Disables all of the button seats apart from the one given in as parameters
     * @param buttonPressed
     */
    public void disableTheRestOfButtons(JToggleButton buttonPressed) {
	for(JToggleButton button : getAllSeatButtons()){
	    if(!buttonPressed.getName().toLowerCase().equals(button.getName().toLowerCase())){
		button.setEnabled(false);
	    }
	}

    }

/**
 * Enables all of the buttons 
 */
    public void enableAllSeatButtons() {
	for(JToggleButton button : getAllSeatButtons()){
	    button.setEnabled(true);
	}

    }
}
