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
    private Controller theController; /* do I really need it ???*/
    private BusManagementTab busManagementPanel;
    private ReservationTab reservationPanel;
    
    public static final String[] hours = new String[] {"00", "01", "02", "03", "04", "05", "06",
	    "07", "08", "09", "10", "11", "12",
	    "13", "14", "15", "16", "17", "18",
	    "19", "20", "21", "22", "23"};
    
    public static final String[] minutes = new String[] {"00", "01", "02", "03", "04", "05", "06",
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
    
    public static final String[] allowedBusTypes = new String[] {"Mercedes 121"
    };

    
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
	
	/*Reservation Tab*/
	reservationPanel = new ReservationTab();
	tabbedPane.addTab("Reservation", null, reservationPanel, null);
	reservationPanel.setLayout(null);
	
	
	/*Bus Management Tab*/
	busManagementPanel = new BusManagementTab();
	tabbedPane.addTab("Bus Management", null, busManagementPanel, null);
	busManagementPanel.setLayout(null);
	
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

    public BusManagementTab getBusManagementPanel() {
        return busManagementPanel;
    }

    public ReservationTab getReservationPanel() {
        return reservationPanel;
    }

    
}
