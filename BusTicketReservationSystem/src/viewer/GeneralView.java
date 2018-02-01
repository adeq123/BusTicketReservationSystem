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
    private JFrame     Frame;
    private JTextField DDField;
    private JTextField MMField;
    private JTextField YYYYField;
    
    public final String[] hours = new String[] {"00", "01", "02", "03", "04", "05", "06",
	    "07", "08", "09", "10", "11", "12",
	    "13", "14", "15", "16", "17", "18",
	    "19", "20", "21", "22", "23"};
    
    public final String[] minutes = new String[] {"00", "01", "02", "03", "04", "05", "06",
	        "07", "08", "09", "10", "11", "12",
	        "13", "14", "15", "16", "17", "18",
	        "19", "20", "21", "22", "23",
	        "24", "25", "26", "27", "28",
	        "29", "30", "31", "32", "33",
	        "34", "35", "36", "37", "38",
	        "39", "40", "41", "42", "43",
	        "44", "45", "46", "47", "48",
	        "49", "50", "51", "52", "53",
	        "54", "55", "56", "57", "58",
	        "59", "60"	    
	        };
    
    public final allowedBusTypes = new String[] {"Mercedes 121"
    };
    
    private BusManagementTab data = new BusManagementTab();

    /**
     * Create the application.
     */
    public GeneralView(Controller theController) {
	this.data.theController = theController;
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	data.Frame = new JFrame();
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
	
	
	data.DDField = new JTextField();
	data.DDField.setHorizontalAlignment(SwingConstants.CENTER);
	data.DDField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(2)); //numbers only and two characters only
	
		data.DDField.setBounds(165, 55, 25, 20);
		ReservationPanel.add(data.DDField);
		
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(200, 58, 9, 14);
		ReservationPanel.add(label_1);
		
		data.MMField = new JTextField();
		data.MMField.setHorizontalAlignment(SwingConstants.CENTER);
		data.MMField.setBounds(211, 55, 25, 20);
		data.MMField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(2)); //numbers only and two characters only
		ReservationPanel.add(data.MMField);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(240, 58, 9, 14);
		ReservationPanel.add(label_2);
		
		data.YYYYField = new JTextField();
		data.YYYYField.setHorizontalAlignment(SwingConstants.CENTER);
		data.YYYYField.setBounds(259, 55, 50, 20);
		data.YYYYField.setDocument(new JTextFieldIntOnlyAndNumberOfCharFilter(4)); //numbers only and 4 characters only
		ReservationPanel.add(data.YYYYField);
		
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
	
	data.tfBusID = new JTextField();
	data.tfBusID.setBounds(86, 11, 150, 20);
	data.tfBusID.setDocument(new JTextFieldIntOnlyFilter()); //numbers only;
	BusManagementPanel.add(data.tfBusID);
	data.tfBusID.setColumns(10);
	
	JLabel lblBusName = new JLabel("Bus name :");
	lblBusName.setBounds(10, 36, 71, 17);
	lblBusName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblBusName);
	
	data.tfBusName = new JTextField();
	data.tfBusName.setBounds(86, 36, 150, 20);
	BusManagementPanel.add(data.tfBusName);
	data.tfBusName.setColumns(10);
	
	JLabel lblFrom = new JLabel("From :");
	lblFrom.setBounds(10, 120, 41, 17);
	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblFrom);
	
	JLabel lblTiming = new JLabel("Time :");
	lblTiming.setBounds(10, 145, 71, 20);
	lblTiming.setFont(new Font("Tahoma", Font.PLAIN, 14));
	BusManagementPanel.add(lblTiming);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(256, 11, 790, 270);
	BusManagementPanel.add(scrollPane);
	
	data.table = new JTable();
	data.table.setModel(new DefaultTableModel(
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
	scrollPane.setViewportView(data.table);
	
	JLabel lblBusType_1 = new JLabel("Bus type:");
	lblBusType_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBusType_1.setBounds(10, 64, 71, 20);
	BusManagementPanel.add(lblBusType_1);
	
	JLabel lblTo_1 = new JLabel("To:");
	lblTo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTo_1.setBounds(10, 176, 46, 14);
	BusManagementPanel.add(lblTo_1);
	
	JLabel lblTime = new JLabel("Time:");
	lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTime.setBounds(10, 201, 46, 14);
	BusManagementPanel.add(lblTime);
	
	JLabel lblDistance = new JLabel("Distance:");
	lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDistance.setBounds(10, 226, 71, 14);
	BusManagementPanel.add(lblDistance);
	
	data.tfDistance = new JTextField();
	data.tfDistance.setBounds(86, 225, 150, 20);
	data.tfDistance.setDocument(new JTextFieldIntOnlyFilter()); //numbers only;
	BusManagementPanel.add(data.tfDistance);
	data.tfDistance.setColumns(10);
	
	data.btnAdd = new JButton("Add");
	data.btnAdd.setBounds(10, 256, 89, 23);
	BusManagementPanel.add(data.btnAdd);
	
	data.btnDelete = new JButton("Delete");
	data.btnDelete.setBounds(136, 256, 89, 23);
	BusManagementPanel.add(data.btnDelete);
	
	data.btnUpdate = new JButton("Update");
	data.btnUpdate.setBounds(136, 290, 89, 23);
	BusManagementPanel.add(data.btnUpdate);
	
	data.btnRefreshTable = new JButton("Refresh table");
	data.btnRefreshTable.setBounds(505, 292, 190, 23);
	BusManagementPanel.add(data.btnRefreshTable);
	
	JLabel lblSeatsOccupied = new JLabel("Seats occupied:");
	lblSeatsOccupied.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblSeatsOccupied.setBounds(10, 95, 76, 14);
	BusManagementPanel.add(lblSeatsOccupied);
	
	data.tfSeatsOccupied = new JTextField();
	data.tfSeatsOccupied.setBounds(86, 94, 150, 20);
	BusManagementPanel.add(data.tfSeatsOccupied);
	data.tfSeatsOccupied.setColumns(10);
	
	data.btnFetchRecord = new JButton("Fetch record");
	data.btnFetchRecord.setBounds(10, 290, 89, 23);
	BusManagementPanel.add(data.btnFetchRecord);
	
	data.tfFrom = new JTextField();
	data.tfFrom.setBounds(86, 120, 150, 20);
	BusManagementPanel.add(data.tfFrom);
	data.tfFrom.setColumns(10);
	
	JLabel label_3 = new JLabel(":");
	label_3.setBounds(147, 148, 10, 14);
	BusManagementPanel.add(label_3);
	
	data.tfTo = new JTextField();
	data.tfTo.setBounds(86, 175, 150, 20);
	BusManagementPanel.add(data.tfTo);
	data.tfTo.setColumns(10);
	
	data.cbHHFrom = new JComboBox(data.hours);
	data.cbHHFrom.setBounds(96, 145, 48, 20);
	BusManagementPanel.add(data.cbHHFrom);
	
	data.cbMMFrom = new JComboBox(data.minutes);
	data.cbMMFrom.setBounds(157, 145, 49, 20);
	BusManagementPanel.add(data.cbMMFrom);
	
	JLabel label_4 = new JLabel(":");
	label_4.setBounds(147, 202, 10, 14);
	BusManagementPanel.add(label_4);
	
	data.cbHHTo = new JComboBox(data.hours);
	data.cbHHTo.setBounds(96, 199, 48, 20);
	BusManagementPanel.add(data.cbHHTo);
	
	data.cbMMTo = new JComboBox(data.minutes);
	data.cbMMTo.setBounds(157, 199, 49, 20);
	BusManagementPanel.add(data.cbMMTo);
	
	data.cbBusType = new JComboBox(data.allowedBusTypes);
	data.cbBusType.setBounds(86, 67, 150, 20);
	BusManagementPanel.add(data.cbBusType);
	
		
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
	return data.Frame;
    }

    public JButton getBtnAdd() {
        return data.btnAdd;
    }

    public JButton getBtnDelete() {
        return data.btnDelete;
    }

    public JButton getBtnUpdate() {
        return data.btnUpdate;
    }

    public JButton getBtnRefreshTable() {
        return data.btnRefreshTable;
    }

    public JButton getBtnFetchRecord() {
        return data.btnFetchRecord;
    }
}
