package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import javax.swing.JToggleButton;

import org.junit.Before;
import org.junit.Test;

import viewer.Mercedes121Layout;

public class BusLayoutPanelTest {
    Mercedes121Layout busPanel;
    @Before
    public void setUp() throws Exception {
	busPanel = new Mercedes121Layout();
    }

    @Test
    public void testGetAllSeatButtons() {
	LinkedList<JToggleButton> seats = busPanel.getAllSeatButtons();
	assertTrue(seats.size() == 30);
    }
    
    @Test
    public void testGetSelectedSeat() {
	JToggleButton seat = busPanel.getSelectedSeat("seat21");
	assertTrue(seat.getName() == "seat21");
	
	seat = busPanel.getSelectedSeat("seat31");
	assertTrue(seat == null);
    }
}
