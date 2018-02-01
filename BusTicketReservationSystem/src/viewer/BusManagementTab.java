package viewer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Controller;

public class BusManagementTab extends JPanel{

    public JTextField tfBusID;
    public JTextField tfBusName;
    public JTable     table;
    public JTextField tfDistance;
    public Controller theController;
    public JTextField tfSeatsOccupied;
    public JButton    btnAdd;
    public JButton    btnDelete;
    public JButton    btnUpdate;
    public JButton    btnRefreshTable;
    public JButton    btnFetchRecord;
    public JTextField tfFrom;
    public JTextField tfTo;
    public String[]   hours;
    public String[]   minutes;
    public String[]   allowedBusTypes;
    public JComboBox  cbBusType;
    public JComboBox  cbHHFrom;
    public JComboBox  cbMMFrom;
    public JComboBox  cbHHTo;
    public JComboBox  cbMMTo;

    public BusManagementTab(String[] hours, String[] minutes,
	    String[] allowedBusTypes) {
	this.hours = hours;
	this.minutes = minutes;
	this.allowedBusTypes = allowedBusTypes;
    }
}