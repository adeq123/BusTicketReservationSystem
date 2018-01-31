package viewer;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import controller.Controller;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

/**
 * This application was developed with WindowsBuilder
 * @author ADRO
 *
 */
public class GeneralView {

    private JFrame Frame;
    private JTextField DDField;
    private JTextField MMField;
    private JTextField YYYYField;
    private JTextField tfBusID;
    private JTextField tfBusName;
    private JTable table;
    private JTextField textField;
    private JTextField tfDistance;
    private Controller theController;
    private JTextField tfSeatsOccupied;
    /**
     * Launch the application.
     */
    //////////////////////////////////////////////////////////////// move  to controller
   /* public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GeneralView window = new GeneralView(null);
		    window.Frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
*/
    /**
     * Create the application.
     */
    public GeneralView(Controller theController) {
	this.theController = theController;
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	Frame = new JFrame();
	getFrame().setBounds(100, 100, 1079, 557);
	getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getFrame().getContentPane().setLayout(new BoxLayout(getFrame().getContentPane(), BoxLayout.X_AXIS));
	
	JPanel mainAplicationPanel = new JPanel();
	getFrame().getContentPane().add(mainAplicationPanel);
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
	tabbedPane.setBounds(10, 147, 1061, 361);
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
		layoutPanel.setLayout(new BorderLayout(0, 0));
		layoutPanel.add(mercedes); //make a method out of it
	
	JPanel BusManagementPanel = new JPanel();
	tabbedPane.addTab("Bus Management", null, BusManagementPanel, null);
	BusManagementPanel.setLayout(null);
	
	JLabel lblBusId = new JLabel("Bus ID :");
	lblBusId.setBounds(10, 11, 49, 17);
	lblBusId.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblBusId);
	
	tfBusID = new JTextField();
	tfBusID.setBounds(86, 11, 150, 20);
	tfBusID.setDocument(new JTextFieldIntOnlyFilter()); //numbers only;
	BusManagementPanel.add(tfBusID);
	tfBusID.setColumns(10);
	
	JLabel lblBusName = new JLabel("Bus name :");
	lblBusName.setBounds(10, 36, 71, 17);
	lblBusName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblBusName);
	
	tfBusName = new JTextField();
	tfBusName.setBounds(86, 36, 150, 20);
	BusManagementPanel.add(tfBusName);
	tfBusName.setColumns(10);
	
	JLabel lblFrom = new JLabel("From :");
	lblFrom.setBounds(10, 120, 41, 17);
	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblFrom);
	
	JComboBox cbFrom = new JComboBox();
	cbFrom.setBounds(86, 120, 150, 20);
	BusManagementPanel.add(cbFrom);
	
	JLabel lblTiming = new JLabel("Time :");
	lblTiming.setBounds(10, 145, 71, 20);
	lblTiming.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblTiming);
	
	JComboBox cbTimeFrom = new JComboBox();
	cbTimeFrom.setBounds(86, 145, 150, 20);
	BusManagementPanel.add(cbTimeFrom);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(256, 11, 790, 270);
	BusManagementPanel.add(scrollPane);
	
	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] {
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null},
		},
		new String[] {
			"Bus ID", "Bus name", "Bus type", "Seats occupied", "Source", "Timing source", "Destination", "Timing destination", "Distance"
		}
	) {
		Class[] columnTypes = new Class[] {
			Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	});
	scrollPane.setViewportView(table);
	
	JLabel lblBusType_1 = new JLabel("Bus type:");
	lblBusType_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBusType_1.setBounds(10, 64, 71, 20);
	BusManagementPanel.add(lblBusType_1);
	
	textField = new JTextField();
	textField.setBounds(86, 66, 150, 20);
	BusManagementPanel.add(textField);
	textField.setColumns(10);
	
	JLabel lblTo_1 = new JLabel("To:");
	lblTo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTo_1.setBounds(10, 176, 46, 14);
	BusManagementPanel.add(lblTo_1);
	
	JComboBox cbTO = new JComboBox();
	cbTO.setBounds(86, 176, 150, 20);
	BusManagementPanel.add(cbTO);
	
	JLabel lblTime = new JLabel("Time:");
	lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTime.setBounds(10, 201, 46, 14);
	BusManagementPanel.add(lblTime);
	
	JComboBox cbTimeTo = new JComboBox();
	cbTimeTo.setBounds(86, 200, 150, 20);
	BusManagementPanel.add(cbTimeTo);
	
	JLabel lblDistance = new JLabel("Distance:");
	lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDistance.setBounds(10, 226, 71, 14);
	BusManagementPanel.add(lblDistance);
	
	tfDistance = new JTextField();
	tfDistance.setBounds(86, 225, 150, 20);
	tfDistance.setDocument(new JTextFieldIntOnlyFilter()); //numbers only;
	BusManagementPanel.add(tfDistance);
	tfDistance.setColumns(10);
	
	JButton btnAdd = new JButton("Add");
	btnAdd.setBounds(10, 256, 89, 23);
	BusManagementPanel.add(btnAdd);
	
	JButton btnDelete = new JButton("Delete");
	btnDelete.setBounds(136, 256, 89, 23);
	BusManagementPanel.add(btnDelete);
	
	JButton btnUpdate = new JButton("Update");
	btnUpdate.setBounds(136, 290, 89, 23);
	BusManagementPanel.add(btnUpdate);
	
	JButton btnRefreshTable = new JButton("Refresh table");
	btnRefreshTable.setBounds(505, 292, 190, 23);
	BusManagementPanel.add(btnRefreshTable);
	
	JLabel lblSeatsOccupied = new JLabel("Seats occupied:");
	lblSeatsOccupied.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblSeatsOccupied.setBounds(10, 95, 76, 14);
	BusManagementPanel.add(lblSeatsOccupied);
	
	tfSeatsOccupied = new JTextField();
	tfSeatsOccupied.setBounds(86, 94, 150, 20);
	BusManagementPanel.add(tfSeatsOccupied);
	tfSeatsOccupied.setColumns(10);
	
	JButton btnFetchRecord = new JButton("Fetch record");
	btnFetchRecord.setBounds(10, 290, 89, 23);
	BusManagementPanel.add(btnFetchRecord);
	
		
	JPanel TicketsPanel = new JPanel();
	tabbedPane.addTab("Tickets Management", null, TicketsPanel, null);
	TicketsPanel.setLayout(null);
	
	JPanel FareCalculatorPanel = new JPanel();
	tabbedPane.addTab("Fare Calculoator", null, FareCalculatorPanel, null);
	FareCalculatorPanel.setLayout(null);
	
	JPanel AdminPanel = new JPanel();
	tabbedPane.addTab("Administration", null, AdminPanel, null);
	AdminPanel.setLayout(null);

    }

    public JFrame getFrame() {
	return Frame;
    }
}
