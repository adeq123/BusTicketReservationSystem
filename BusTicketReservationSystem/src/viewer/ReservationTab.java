package viewer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReservationTab extends JPanel{


    private JTextField DDField;
    private JTextField MMField;
    private JTextField YYYYField;
    private JComboBox <String> fromDropDown;
    private JComboBox <String> toDropDown;
    private JButton btnGetBusDetails;
    private JButton btnReset;
    private JComboBox <String> busListDropDown;
    private JButton btnLoadBuss;

    public ReservationTab(){
	JLabel label = new JLabel("From:");
	label.setFont(new Font("Tahoma", Font.BOLD, 14));
	label.setBounds(10, 11, 46, 14);
	this.add(label);

	fromDropDown = new JComboBox<String>();
	fromDropDown.setBounds(66, 10, 143, 20);
	this.add(fromDropDown);

	JLabel lblTo = new JLabel("To:");
	lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblTo.setBounds(249, 13, 46, 14);
	this.add(lblTo);

	toDropDown = new JComboBox<String>();
	toDropDown.setBounds(288, 10, 157, 20);
	this.add(toDropDown);

	JLabel lblDate = new JLabel("Date:");
	lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDate.setBounds(10, 56, 46, 14);
	this.add(lblDate);

	JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
	lblDdmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDdmmyyyy.setBounds(66, 56, 88, 14);
	this.add(lblDdmmyyyy);


	DDField = new JTextField();
	DDField.setHorizontalAlignment(SwingConstants.CENTER);
	DDField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(2)); //numbers only and two characters only

	DDField.setBounds(165, 55, 25, 20);
	this.add(DDField);


	JLabel label_1 = new JLabel("/");
	label_1.setBounds(200, 58, 9, 14);
	this.add(label_1);

	MMField = new JTextField();
	MMField.setHorizontalAlignment(SwingConstants.CENTER);
	MMField.setBounds(211, 55, 25, 20);
	MMField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(2)); //numbers only and two characters only
	this.add(MMField);

	JLabel label_2 = new JLabel("/");
	label_2.setBounds(240, 58, 9, 14);
	this.add(label_2);

	YYYYField = new JTextField();
	YYYYField.setHorizontalAlignment(SwingConstants.CENTER);
	YYYYField.setBounds(259, 55, 50, 20);
	YYYYField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(4)); //numbers only and 4 characters only
	this.add(YYYYField);

	btnGetBusDetails = new JButton("Get Bus Details");
	btnGetBusDetails.setBounds(319, 54, 126, 23);
	this.add(btnGetBusDetails);

	btnReset = new JButton("Reset");
	btnReset.setBounds(455, 54, 89, 23);
	this.add(btnReset);

	JLabel lblSelectBusFrom = new JLabel("Select bus from list & Click Load :");
	lblSelectBusFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblSelectBusFrom.setBounds(10, 102, 212, 14);
	this.add(lblSelectBusFrom);

	busListDropDown = new <String> JComboBox();
	busListDropDown.setBounds(221, 101, 224, 20);
	this.add(busListDropDown);

	JButton btnMakeReservation = new JButton("Make Reservation");
	btnMakeReservation.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) { //MOVE TO CONTROLLER
		PassengerWindow passenger = new PassengerWindow();
		passenger.newScreen();
	    }
	});
	btnMakeReservation.setBounds(187, 171, 143, 58);
	this.add(btnMakeReservation);

	JLabel lblBusType = new JLabel("Bus type:");
	lblBusType.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBusType.setBounds(10, 127, 65, 20);
	this.add(lblBusType);

	JLabel lblShowbustype = new JLabel("showBusType");
	lblShowbustype.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowbustype.setBounds(78, 132, 88, 14);
	this.add(lblShowbustype);

	btnLoadBuss = new JButton("Load");
	btnLoadBuss.setBounds(455, 100, 89, 23);
	this.add(btnLoadBuss);

	Mercedes121Layout mercedes = new Mercedes121Layout();
	JPanel layoutPanel = new JPanel();
	layoutPanel.setBounds(575, 31, 460, 198);
	this.add(layoutPanel);
	layoutPanel.setLayout(new BorderLayout(0, 0));
	layoutPanel.add(mercedes); //make a method out of it

	/* default values*/
	setDefaultDateOnReservation(); ////////////////////////// MOVE TO CONTROLLER ?
    }

    public JTextField getDDField() {
	return DDField;
    }

    public JTextField getMMField() {
	return MMField;
    }

    public JTextField getYYYYField() {
	return YYYYField;
    }

    public JComboBox <String> getFromDropDown() {
	return fromDropDown;
    }

    public JComboBox <String> getToDropDown() {
	return toDropDown;
    }

    /**
     * Sets a default date on the reservation on today
     */
    public void setDefaultDateOnReservation(){
	YYYYField.setText(Integer.toString(Year.now().getValue()));

	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	LocalDate tomorrow = localDate.plusDays(1);

	int month = tomorrow.getMonthValue();
	MMField.setText(getSSformat(month));

	int day = tomorrow.getDayOfMonth();
	DDField.setText(getSSformat(day));
    }
    
    /**
     * Formats months and days to two digit date (MM or DD) depending on the input
     * @param monthOrDay
     * @return, String, two digit MM or DD date
     */
    public String getSSformat(int monthOrDay){
	if(monthOrDay < 10){
	    return "0" + Integer.toString(monthOrDay);
	}else{
	    return Integer.toString(monthOrDay);
	}
    }

    public JButton getBtnReset() {
        return btnReset;
    }
    
    public JComboBox<String> getBusListDropDown() {
        return busListDropDown;
    }

    public JButton getBtnGetBusDetails() {
	return btnGetBusDetails;
    }

    public JButton getBtnLoadBuss() {
        return btnLoadBuss;
    }
}
