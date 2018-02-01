package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DataBaseModel;
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
	theView.getBtnAdd().addActionListener(new AddBusListener());
	
    }

	/* Bus Management tab listeners*/
    public class AddBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    int busID = theView.ge
	  dbModel.insertNewBus(,busName, busType, seatsOccupied, source, timing, destination, timingDestination, distance);

	}
    }
    
    public class DelteBusListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    // TODO Auto-generated method stub

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
	    // TODO Auto-generated method stub

	}
    }
}
