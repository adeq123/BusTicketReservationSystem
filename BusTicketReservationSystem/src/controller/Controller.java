package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable;

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
    }
    /**
     * The method initialize the listeners for the application
     */
    private void initializeListeners() {
	/* Bus management TAB*/
	theView.getBusManagementPanel().getBtnAdd().addActionListener(new AddBusListener());
	theView.getBusManagementPanel().getBtnRefreshTable().addActionListener(new RefreshTableListener());
	theView.getBusManagementPanel().getBtnFetchRecord().addActionListener(new FetchBusListener());
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
     * The method cleans up all of the fields in Bus Management Tab and puts ot to defualt value
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
	    }

	}
    }

    public class DelteBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    try {
		dbModel.deleteBusWithID(Integer.parseInt(theView.getBusManagementPanel().getTfBusID().getText()));
	    } catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    public class UpdateBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    // TODO Auto-generated method stub

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
		
		theView.getBusManagementPanel().getTfTo().setText((String) busTimeTable.getValueAt(row, 6));
		System.out.println((Float) busTimeTable.getValueAt(row, 8));
		theView.getBusManagementPanel().getTfDistance().setText(Float.toString((Float) busTimeTable.getValueAt(row, 8)));
	    }else{
		///////////////////////////////////////////Exception  if there is no record in the table it will return -1
	    }
	}
    }

    public class RefreshTableListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    getAndShowBusTimeTable();
	}
    }
    /**
     * Searches for index of the myBusType cell in the GeneralView.allowedBusTypes matrix
     * @param myBusType
     * @return, int, index of the myBusType cell in the GeneralView.allowedBusTypes matrix. If not find 
     * returns 0 as default (also if the bus type you are looking for is at index 0)
     */
    public int findBusType(String myBusType) {
	int i = 0;
	for(String str : GeneralView.allowedBusTypes){
	    if(str.toLowerCase().equals(myBusType.toLowerCase())){
		return i;
	    }
	}
	return i;
    }






}
