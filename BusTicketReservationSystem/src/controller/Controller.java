package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.DataBaseModel;
import net.proteanit.sql.DbUtils;
import viewer.GeneralView;
/**
 * This class models and Controller part of the application designed in MVC concept. 
 * It is responsible for all the communication between the Model and Viewer modeling the application logic at the same time.
 * @author ADRO
 *
 */
public class Controller {

    private GeneralView theView;
    private DataBaseModel dbModel;

    public void start(){
	theView = new GeneralView (this);
	dbModel = new DataBaseModel();
	theView.getFrame().setVisible(true);

	initializeListeners();
	getAndShowBusTimeTable();
	theView.getBusManagementPanel().getTfBusID().setText(suggestBusID().toString());
	fillFromComboBox();
	fillToComboBox();
	;
    }
    /**
     * The method initialize the listeners for the application
     */
    private void initializeListeners() {
	/* Bus management TAB*/
	theView.getBusManagementPanel().getBtnAdd().addActionListener(new AddBusListener());
	theView.getBusManagementPanel().getBtnRefreshTable().addActionListener(new RefreshTableListener());
	theView.getBusManagementPanel().getBtnFetchRecord().addActionListener(new FetchBusListener());
	theView.getBusManagementPanel().getBtnDelete().addActionListener(new DeleteBusListener());
	theView.getBusManagementPanel().getBtnUpdate().addActionListener(new UpdateBusListener());

	/* Tabbed Pane from general view*/
	theView.getTabbedPane().addChangeListener(new TabbedPaneChangeListener());

	/* Reservation Panel*/
	theView.getReservationPanel().getFromDropDown().addActionListener(new ToCbListener());
	theView.getReservationPanel().getBtnGetBusDetails().addActionListener(new BtnGetBusDetailsListener());
	theView.getReservationPanel().getBtnReset().addActionListener(new BtnResetListener());
    }

    /**
     * The method takes all of the records in corresponding bus time table database and displays it in BusManagementTab
     */
    public void getAndShowBusTimeTable(){
	JTable busTimeTable = theView.getBusManagementPanel().getBusTimeTable();
	ResultSet rs;
	try {
	    rs = dbModel.getBusTimeTable();
	    busTimeTable.setModel(DbUtils.resultSetToTableModel(rs));
	    busTimeTable.changeSelection(0, 0, false, false); //default selection on first record
	} catch (Exception e) {
	    /* ERROR MESSEAGE POPING UP HERE*/
	    System.out.println(e.getMessage());
	}
    }
    /**
     * The method cleans up all of the fields in Bus Management Tab and puts it to defualt value
     */
    public void cleanBusMangementFields() {
	theView.getBusManagementPanel().getTfBusID().setText(suggestBusID().toString());
	theView.getBusManagementPanel().getTfBusName().setText("");
	theView.getBusManagementPanel().getCbBusType().setSelectedIndex(0);
	theView.getBusManagementPanel().getTfSeatsOccupied().setText("");
	theView.getBusManagementPanel().getTfFrom().setText("");   
	theView.getBusManagementPanel().getCbHHFrom().setSelectedIndex(0);
	theView.getBusManagementPanel().getCbMMFrom().setSelectedIndex(0);
	theView.getBusManagementPanel().getTfTo().setText("");
	theView.getBusManagementPanel().getCbHHTo().setSelectedIndex(0);
	theView.getBusManagementPanel().getCbMMTo().setSelectedIndex(0);
	theView.getBusManagementPanel().getTfDistance().setText("");

    }
    /**
     * Calculates the next free id (incrementally)
     * @return, Integer, Next free ID number
     */
    private Integer suggestBusID() {
	try {
	    ResultSet rs = dbModel.getAllBusID();
	    ArrayList<ArrayList<Integer>> idList = (ArrayList<ArrayList<Integer>>) DbUtils.resultSetToNestedList(rs);
	    return  idList.get(idList.size() - 1).get(0) + 1;
	} catch (Exception e) {
	    /* ERROR MESSEAGE POPING UP HERE*/
	    System.out.println(e.getMessage());
	}
	return null;
    }
    /* Bus Management tab listeners*/
    public class AddBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {

	    int busID = Integer.parseInt(theView.getBusManagementPanel().getTfBusID().getText());
	    String busName = theView.getBusManagementPanel().getTfBusName().getText();
	    String busType = (String) theView.getBusManagementPanel().getCbBusType().getSelectedItem();
	    String seatsOccupied = (String) theView.getBusManagementPanel().getTfSeatsOccupied().getText();
	    String source = (String) theView.getBusManagementPanel().getTfFrom().getText();   
	    String timing = (String) theView.getBusManagementPanel().getCbHHFrom().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMFrom().getSelectedItem();
	    String destination = theView.getBusManagementPanel().getTfTo().getText();
	    String timingDestination = (String) theView.getBusManagementPanel().getCbHHTo().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMTo().getSelectedItem();
	    double distance = Double.parseDouble(theView.getBusManagementPanel().getTfDistance().getText());

	    try {
		dbModel.insertNewBus(busID,busName, busType, seatsOccupied, source, timing, destination, timingDestination, distance);
		getAndShowBusTimeTable();
		cleanBusMangementFields();
	    } catch (Exception e) {
		System.out.println(e.getMessage());
		/* ERROR MESSEAGE POPING UP HERE*/
	    }

	}
    }

    public class DeleteBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    try {
		dbModel.deleteBusWithID(Integer.parseInt(theView.getBusManagementPanel().getTfBusID().getText()));
		getAndShowBusTimeTable();
		cleanBusMangementFields();
	    } catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		/* ERROR MESSEAGE POPING UP HERE*/
	    }
	}
    }

    public class UpdateBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    int busID = Integer.parseInt(theView.getBusManagementPanel().getTfBusID().getText());
	    String busName = theView.getBusManagementPanel().getTfBusName().getText();
	    String busType = (String) theView.getBusManagementPanel().getCbBusType().getSelectedItem();
	    String seatsOccupied = (String) theView.getBusManagementPanel().getTfSeatsOccupied().getText();
	    String source = (String) theView.getBusManagementPanel().getTfFrom().getText();   
	    String timing = (String) theView.getBusManagementPanel().getCbHHFrom().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMFrom().getSelectedItem();
	    String destination = theView.getBusManagementPanel().getTfTo().getText();
	    String timingDestination = (String) theView.getBusManagementPanel().getCbHHTo().getSelectedItem() 
		    + ":" + (String) theView.getBusManagementPanel().getCbMMTo().getSelectedItem();
	    double distance = Double.parseDouble(theView.getBusManagementPanel().getTfDistance().getText());
	    System.out.println(busID);
	    try {
		dbModel.updateBusRecord(busID,busName, busType, seatsOccupied, source, timing, destination, timingDestination, distance);
		getAndShowBusTimeTable();
		cleanBusMangementFields();
	    } catch (Exception e) {
		System.out.println(e.getMessage());
		/* ERROR MESSEAGE POPING UP HERE*/
	    }

	}
    }

    public class FetchBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    JTable busTimeTable = theView.getBusManagementPanel().getBusTimeTable();
	    int row =  busTimeTable.getSelectedRow();
	    if(row >= 0){
		theView.getBusManagementPanel().getTfBusID().setText(Integer.toString((Integer) busTimeTable.getValueAt(row, 0))); //busID
		theView.getBusManagementPanel().getTfBusName().setText((String) busTimeTable.getValueAt(row, 1)); //bus Name
		theView.getBusManagementPanel().getCbBusType().setSelectedIndex(findBusType((String) busTimeTable.getValueAt(row, 2)));
		theView.getBusManagementPanel().getTfSeatsOccupied().setText((String) busTimeTable.getValueAt(row, 3));
		theView.getBusManagementPanel().getTfFrom().setText((String) busTimeTable.getValueAt(row, 4));
		theView.getBusManagementPanel().getCbHHFrom().setSelectedIndex(findHour(busTimeTable.getValueAt(row, 5)));
		theView.getBusManagementPanel().getCbMMFrom().setSelectedIndex(findMinutes(busTimeTable.getValueAt(row, 5)));
		theView.getBusManagementPanel().getTfTo().setText((String) busTimeTable.getValueAt(row, 6));
		theView.getBusManagementPanel().getCbHHTo().setSelectedIndex(findHour(busTimeTable.getValueAt(row, 7)));
		theView.getBusManagementPanel().getCbMMTo().setSelectedIndex(findMinutes(busTimeTable.getValueAt(row, 7)));
		theView.getBusManagementPanel().getTfDistance().setText(Float.toString((Float) busTimeTable.getValueAt(row, 8)));
	    }else{
		///////////////////////////////////////////Exception  if there is no record in the table it will return -1
	    }
	}


    }

    public class ToCbListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    fillToComboBox() ;
	}

    }

    public class TabbedPaneChangeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent arg0) {
	    if(theView.getTabbedPane().getSelectedIndex() == theView.getTabbedPane().indexOfTab("Reservation")){ //if reservation panel is selected
		fillFromComboBox();
		fillToComboBox();
	    }

	}

    }

    public class RefreshTableListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    getAndShowBusTimeTable();
	}
    }

    public class BtnGetBusDetailsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    String to = theView.getReservationPanel().getToDropDown().getSelectedItem().toString();
	    String from = theView.getReservationPanel().getFromDropDown().getSelectedItem().toString();

	    theView.getReservationPanel().getToDropDown().setEnabled(false);
	    theView.getReservationPanel().getFromDropDown().setEnabled(false);
	    theView.getReservationPanel().getYYYYField().setEnabled(false);
	    theView.getReservationPanel().getDDField().setEnabled(false);
	    theView.getReservationPanel().getMMField().setEnabled(false);
	    theView.getReservationPanel().getBtnGetBusDetails().setEnabled(false);
	    fillBusListDropDown(from, to);
	    try {
		dbModel.getBusDetials(from, to);
	    } catch (Exception e1) {
		e1.printStackTrace();
	    }
	}
    }

    public class BtnResetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    String to = theView.getReservationPanel().getToDropDown().getSelectedItem().toString();
	    String from = theView.getReservationPanel().getFromDropDown().getSelectedItem().toString();

	    theView.getReservationPanel().getToDropDown().setEnabled(true);
	    theView.getReservationPanel().getFromDropDown().setEnabled(true);
	    theView.getReservationPanel().getYYYYField().setEnabled(true);
	    theView.getReservationPanel().getDDField().setEnabled(true);
	    theView.getReservationPanel().getMMField().setEnabled(true);
	    theView.getReservationPanel().getBtnGetBusDetails().setEnabled(true);
	    try {
		dbModel.getBusDetials(from, to);
	    } catch (Exception e1) {
		e1.printStackTrace();
	    }
	}
    }
    /**
     * Searches for index of the myBusType cell in the GeneralView.allowedBusTypes matrix
     * @param myBusType
     * @return, int, index of the myBusType cell in the GeneralView.allowedBusTypes matrix. If not find 
     * returns 0 as default (also if the bus type you are looking for is at index 0)
     * @see GeneralView
     */
    public int findBusType(String myBusType) {
	int i = 0;
	for(String str : GeneralView.allowedBusTypes){
	    if(str.toLowerCase().equals(myBusType.toLowerCase())){
		return i;
	    }
	    i++;
	}
	return i;
    }


    /**
     * Searches for index of the Hour cell in the GeneralView.hours matrix
     * @param hours
     * @return, int, index of the hours cell in the hours matrix. If not find 
     * returns 0 as default (also if the bus type you are looking for is at index 0)
     * @see GeneralView
     */
    public int findHour(Object hh) {
	String HH = hh.toString().substring(0,2);
	int i = 0;
	for(String str : GeneralView.hours){
	    if(str.toLowerCase().equals(HH)){
		return i;
	    }
	    i++;
	}
	return i;
    }

    /**
     * Searches for index of the minute cell in the GeneralView.minutes matrix
     * @param MINUTES
     * @return, int, index of the MINUTE cell in the MINUTES matrix. If not find 
     * returns 0 as default (also if the bus type you are looking for is at index 0)
     * @see GeneralView
     */
    public int findMinutes(Object time) {
	String mm = time.toString().substring(3,5);
	int i = 0;
	for(String str : GeneralView.minutes){
	    if(str.toLowerCase().equals(mm)){
		return i;
	    }
	    i++;
	}
	return i;
    }

    /**
     * Fills from ComboBox with all possible source towns
     */
    public void fillFromComboBox(){
	theView.getReservationPanel().getFromDropDown().removeAllItems();
	try {
	    ResultSet rs = dbModel.getBusTimeTable();
	    String name = "";
	    while(rs.next()){
		name = rs.getString("source");
		theView.getReservationPanel().getFromDropDown().addItem(name);
	    }
	    fillToComboBox();
	} catch (Exception e) {
	    /*Handle Error here!*/
	    e.printStackTrace();
	}
    }

    /**
     * Fills To ComboBox with all possible desinations
     */


    public void fillToComboBox() {
	theView.getReservationPanel().getToDropDown().removeAllItems();
	try {
	    ResultSet rs = dbModel.getBusTimeTable();
	    String to = "";
	    String from = "";
	    while(rs.next()){
		to = rs.getString("destination");
		from = rs.getString("source");
		if(theView.getReservationPanel().getFromDropDown().getSelectedItem().toString().toLowerCase().equals(from.toLowerCase())){//add only destinations available for the source
		    theView.getReservationPanel().getToDropDown().addItem(to);
		}
	    }
	} catch (Exception e) {
	    /*Handle Error here!*/
	    e.printStackTrace();
	}

    }
    /**
     * Fills To ComboBox with all possible buses leaving to the destination that day
     */
    public void fillBusListDropDown(String from, String to){
	theView.getReservationPanel().getBusListDropDown().removeAllItems();
	try {
	    ResultSet rs = dbModel.getBusDetials(from, to);
	    String company = "";
	    String time = "";
	    while(rs.next()){
		company = rs.getString("busName");
		time = rs.getString("timingSource");
		theView.getReservationPanel().getBusListDropDown().addItem(company + " " + time);

	    }
	} catch (Exception e) {
	    /*Handle Error here!*/
	    e.printStackTrace();
	}
    }
}
