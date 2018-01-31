package viewer;

import java.util.LinkedList;

import javax.swing.JToggleButton;

/**
 * This interface models layout of general bus
 * @author ADRO
 *
 */

public interface BusLayout {
    /**
     * This method returns all seats, modeled as JToggleButton, on the layout
     * @return, LinkedList<JToggleButton>, a list of seats
     */
    public LinkedList<JToggleButton> getAllSeatButtons();
    /**
     * This method returns one seat pointed by seatName
     * @param seatName, a name of desired seat
     * @return, desired seat pointed by seatName
     */
    public JToggleButton getSelectedSeat(String seatName);
}
