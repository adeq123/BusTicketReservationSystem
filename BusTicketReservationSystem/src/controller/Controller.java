package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTable;

import model.DataBaseModel;
import net.proteanit.sql.DbUtils;
import viewer.GeneralView;

public class Controller {

    private GeneralView theView;
    private DataBaseModel dbModel;

    public void start(){
	theView = new GeneralView (this);
	dbModel = new DataBaseModel();
	theView.getFrame().setVisible(true);

	initializeListeners();
    }
    private void initializeListeners() {
	/* Bus management TAB*/
	theView.getBusManagementPanel().getBtnAdd().addActionListener(new AddBusListener());
	theView.getBusManagementPanel().getBtnRefreshTable().addActionListener(new RefreshTableListener());
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
	    } catch (Exception e) {
		System.out.println(e.getMessage());
	    }

	}
    }

    public class DelteBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {

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
	    // TODO Auto-generated method stub

	}
    }

    public class RefreshTableListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    JTable busTimeTable = theView.getBusManagementPanel().getBusTimeTable();
	    ResultSet rs;
	    try {
		rs = dbModel.getBusTimeTable();
		busTimeTable.setModel(DbUtils.resultSetToTableModel(rs));
	    } catch (Exception e) {
		/* ERROR MESSEAGE POPING UP HERE*/
		System.out.println(e.getMessage());
	    }

	}
    }
}
