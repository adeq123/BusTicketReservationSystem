package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.PlainDocument;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

public class GeneralView {

    private JFrame Frame;
    private JTextField DDField;
    private JTextField MMField;
    private JTextField YYYYField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GeneralView window = new GeneralView();
		    window.Frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public GeneralView() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	Frame = new JFrame();
	Frame.setBounds(100, 100, 1079, 526);
	Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Frame.getContentPane().setLayout(new BoxLayout(Frame.getContentPane(), BoxLayout.X_AXIS));
	
	JPanel mainAplicationPanel = new JPanel();
	Frame.getContentPane().add(mainAplicationPanel);
	mainAplicationPanel.setLayout(null);
	
	JLabel lblBusTicketReservation = new JLabel("Bus Ticket Reservation Application ver 1.0");
	lblBusTicketReservation.setBounds(351, 34, 602, 57);
	lblBusTicketReservation.setFont(new Font("Tahoma", Font.BOLD, 27));
	mainAplicationPanel.add(lblBusTicketReservation);
	
	JLabel lblBusImage = new JLabel("");
	lblBusImage.setIcon(new ImageIcon(GeneralView.class.getResource("/viewer/busImage.jpg")));
	lblBusImage.setBounds(105, 11, 176, 104);
	mainAplicationPanel.add(lblBusImage);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 147, 1061, 335);
	mainAplicationPanel.add(tabbedPane);
	
	JPanel ReservationPanel = new JPanel();
	tabbedPane.addTab("Reservation", null, ReservationPanel, null);
	ReservationPanel.setLayout(null);
	
	JLabel label = new JLabel("From:");
	label.setFont(new Font("Tahoma", Font.BOLD, 14));
	label.setBounds(10, 11, 46, 14);
	ReservationPanel.add(label);
	
	JComboBox fromDropDown = new JComboBox();
	fromDropDown.setBounds(66, 10, 143, 20);
	ReservationPanel.add(fromDropDown);
	
	JLabel lblTo = new JLabel("To:");
	lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblTo.setBounds(249, 13, 46, 14);
	ReservationPanel.add(lblTo);
	
	JComboBox toDropDown = new JComboBox();
	toDropDown.setBounds(288, 10, 157, 20);
	ReservationPanel.add(toDropDown);
	
	JLabel lblDate = new JLabel("Date:");
	lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDate.setBounds(10, 56, 46, 14);
	ReservationPanel.add(lblDate);
	
	JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
	lblDdmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDdmmyyyy.setBounds(66, 56, 88, 14);
	ReservationPanel.add(lblDdmmyyyy);
	
	
	DDField = new JTextField();
	DDField.setHorizontalAlignment(SwingConstants.CENTER);
	DDField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(2)); //numbers only and two characters only
	
		DDField.setBounds(165, 55, 25, 20);
		ReservationPanel.add(DDField);
		
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(200, 58, 9, 14);
		ReservationPanel.add(label_1);
		
		MMField = new JTextField();
		MMField.setHorizontalAlignment(SwingConstants.CENTER);
		MMField.setBounds(211, 55, 25, 20);
		MMField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(2)); //numbers only and two characters only
		ReservationPanel.add(MMField);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(240, 58, 9, 14);
		ReservationPanel.add(label_2);
		
		YYYYField = new JTextField();
		YYYYField.setHorizontalAlignment(SwingConstants.CENTER);
		YYYYField.setBounds(259, 55, 50, 20);
		YYYYField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(4)); //numbers only and 4 characters only
		ReservationPanel.add(YYYYField);
		
		JButton btnGetBusDetails = new JButton("Get Bus Details");
		btnGetBusDetails.setBounds(319, 54, 126, 23);
		ReservationPanel.add(btnGetBusDetails);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(455, 54, 89, 23);
		ReservationPanel.add(btnReset);
		
		JLabel lblSelectBusFrom = new JLabel("Select bus from list & Click Load :");
		lblSelectBusFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectBusFrom.setBounds(10, 102, 212, 14);
		ReservationPanel.add(lblSelectBusFrom);
		
		JComboBox busListDropDown = new JComboBox();
		busListDropDown.setBounds(221, 101, 224, 20);
		ReservationPanel.add(busListDropDown);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //MOVE TO CONTROLLER
			    PassengerWindow passenger = new PassengerWindow();
			    passenger.newScreen();
			}
		});
		btnMakeReservation.setBounds(187, 171, 143, 58);
		ReservationPanel.add(btnMakeReservation);
		
		JLabel lblBusType = new JLabel("Bus type:");
		lblBusType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusType.setBounds(10, 127, 65, 20);
		ReservationPanel.add(lblBusType);
		
		JLabel lblShowbustype = new JLabel("showBusType");
		lblShowbustype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowbustype.setBounds(78, 132, 88, 14);
		ReservationPanel.add(lblShowbustype);
		
		JButton btnLoadBuss = new JButton("Load");
		btnLoadBuss.setBounds(455, 100, 89, 23);
		ReservationPanel.add(btnLoadBuss);
		
		Mercedes121Layout mercedes = new Mercedes121Layout();
		JPanel layoutPanel = new JPanel();
		layoutPanel.setBounds(575, 31, 460, 198);
		ReservationPanel.add(layoutPanel);
		layoutPanel.add(mercedes);
	
		
	JPanel TicketsPanel = new JPanel();
	tabbedPane.addTab("Tickets Management", null, TicketsPanel, null);
	TicketsPanel.setLayout(null);
	
	JPanel BusManagementPanel = new JPanel();
	tabbedPane.addTab("Bus Management", null, BusManagementPanel, null);
	BusManagementPanel.setLayout(null);
	
	JPanel FareCalculatorPanel = new JPanel();
	tabbedPane.addTab("Fare Calculoator", null, FareCalculatorPanel, null);
	FareCalculatorPanel.setLayout(null);
	
	JPanel AdminPanel = new JPanel();
	tabbedPane.addTab("Administration", null, AdminPanel, null);
	AdminPanel.setLayout(null);

    }
}
