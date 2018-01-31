package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerWindow {

    private JFrame frame;
    private JTextField txtName;
    private JTextField txtMobileNumber;
    private JTextField txtEmailAdress;

    /**
     * Launch the application.
     */
    public void newScreen() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PassengerWindow window = new PassengerWindow();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public PassengerWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 361, 365);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblBusTicketReservation = new JLabel("Reservation detials");
	lblBusTicketReservation.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblBusTicketReservation.setBounds(80, 11, 155, 14);
	frame.getContentPane().add(lblBusTicketReservation);
	
	JLabel lblDate = new JLabel("Date:");
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDate.setBounds(10, 36, 46, 14);
	frame.getContentPane().add(lblDate);
	
	JLabel lblBusId = new JLabel("Bus ID");
	lblBusId.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBusId.setBounds(10, 61, 46, 14);
	frame.getContentPane().add(lblBusId);
	
	JLabel lblFrom = new JLabel("From:");
	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblFrom.setBounds(10, 86, 46, 14);
	frame.getContentPane().add(lblFrom);
	
	JLabel lblTo = new JLabel("To:");
	lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTo.setBounds(10, 111, 46, 14);
	frame.getContentPane().add(lblTo);
	
	JLabel lblLeavingTime = new JLabel("Leaving time:");
	lblLeavingTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblLeavingTime.setBounds(10, 136, 98, 14);
	frame.getContentPane().add(lblLeavingTime);
	
	JLabel lblExpectedArrivalTime = new JLabel("Expected arrival time:");
	lblExpectedArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblExpectedArrivalTime.setBounds(10, 161, 144, 14);
	frame.getContentPane().add(lblExpectedArrivalTime);
	
	JLabel lblPassengerDetails = new JLabel("Passenger details:");
	lblPassengerDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassengerDetails.setBounds(26, 180, 128, 20);
	frame.getContentPane().add(lblPassengerDetails);
	
	JLabel lblName = new JLabel("Name:");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblName.setBounds(26, 211, 46, 14);
	frame.getContentPane().add(lblName);
	
	JLabel lblMob = new JLabel("Mob.:");
	lblMob.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblMob.setBounds(26, 236, 46, 14);
	frame.getContentPane().add(lblMob);
	
	JLabel lblMail = new JLabel("E-mail");
	lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblMail.setBounds(26, 261, 46, 14);
	frame.getContentPane().add(lblMail);
	
	txtName = new JTextField();
	txtName.setBounds(80, 210, 86, 20);
	frame.getContentPane().add(txtName);
	txtName.setColumns(10);
	
	txtMobileNumber = new JTextField();
	txtMobileNumber.setBounds(80, 235, 86, 20);
	frame.getContentPane().add(txtMobileNumber);
	txtMobileNumber.setColumns(10);
	
	txtEmailAdress = new JTextField();
	txtEmailAdress.setBounds(80, 260, 86, 20);
	frame.getContentPane().add(txtEmailAdress);
	txtEmailAdress.setColumns(10);
	
	JButton btnSubmit = new JButton("Submit");
	btnSubmit.setBounds(58, 293, 89, 23);
	frame.getContentPane().add(btnSubmit);
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.setBounds(190, 293, 89, 23);
	frame.getContentPane().add(btnCancel);
	
	JLabel lblShowdate = new JLabel("showDate");
	lblShowdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowdate.setBounds(174, 38, 61, 14);
	frame.getContentPane().add(lblShowdate);
	
	JLabel lblShowbusid = new JLabel("showBusID");
	lblShowbusid.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowbusid.setBounds(174, 63, 98, 14);
	frame.getContentPane().add(lblShowbusid);
	
	JLabel lblShowfrom = new JLabel("showFrom");
	lblShowfrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowfrom.setBounds(174, 88, 86, 14);
	frame.getContentPane().add(lblShowfrom);
	
	JLabel lblShowto = new JLabel("showTo");
	lblShowto.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowto.setBounds(174, 113, 86, 14);
	frame.getContentPane().add(lblShowto);
	
	JLabel lblShowleavingtime = new JLabel("showLeavingTime");
	lblShowleavingtime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowleavingtime.setBounds(174, 138, 121, 14);
	frame.getContentPane().add(lblShowleavingtime);
	
	JLabel lblShowarrivaltime = new JLabel("showArrivalTime");
	lblShowarrivaltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblShowarrivaltime.setBounds(174, 163, 105, 14);
	frame.getContentPane().add(lblShowarrivaltime);
    }
}
