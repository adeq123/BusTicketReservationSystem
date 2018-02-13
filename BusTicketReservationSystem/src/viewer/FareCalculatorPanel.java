package viewer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FareCalculatorPanel extends JPanel {

    private JComboBox from;
    private JComboBox to;
    private JButton btnCalculateFare;
    private JLabel lblShowfare;

    /**
     * Create the panel.
     */
    public FareCalculatorPanel() {
    	SpringLayout springLayout = new SpringLayout();
    	setLayout(springLayout);
    	
    	JLabel lblFrom = new JLabel("From:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblFrom, 10, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, lblFrom, 173, SpringLayout.WEST, this);
    	lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblFrom);
    	
    	from = new JComboBox();
    	springLayout.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.WEST, from, 20, SpringLayout.EAST, lblFrom);
    	springLayout.putConstraint(SpringLayout.EAST, from, 169, SpringLayout.EAST, lblFrom);
    	add(from);
    	
    	JLabel lblTo = new JLabel("To:");
    	springLayout.putConstraint(SpringLayout.NORTH, lblTo, 0, SpringLayout.NORTH, lblFrom);
    	springLayout.putConstraint(SpringLayout.WEST, lblTo, 24, SpringLayout.EAST, from);
    	springLayout.putConstraint(SpringLayout.SOUTH, lblTo, 0, SpringLayout.SOUTH, lblFrom);
    	lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	add(lblTo);
    	
    	to = new JComboBox();
    	springLayout.putConstraint(SpringLayout.NORTH, to, 0, SpringLayout.NORTH, lblFrom);
    	springLayout.putConstraint(SpringLayout.WEST, to, 16, SpringLayout.EAST, lblTo);
    	springLayout.putConstraint(SpringLayout.EAST, to, 174, SpringLayout.EAST, lblTo);
    	add(to);
    	
    	btnCalculateFare = new JButton("Calculate Fare");
    	springLayout.putConstraint(SpringLayout.NORTH, btnCalculateFare, 21, SpringLayout.SOUTH, from);
    	springLayout.putConstraint(SpringLayout.WEST, btnCalculateFare, 341, SpringLayout.WEST, this);
    	btnCalculateFare.setFont(new Font("Tahoma", Font.BOLD, 14));
    	add(btnCalculateFare);
    	
    	lblShowfare = new JLabel("");
    	springLayout.putConstraint(SpringLayout.SOUTH, btnCalculateFare, -38, SpringLayout.NORTH, lblShowfare);
    	springLayout.putConstraint(SpringLayout.NORTH, lblShowfare, 134, SpringLayout.NORTH, this);
    	springLayout.putConstraint(SpringLayout.EAST, lblShowfare, -468, SpringLayout.EAST, this);
    	lblShowfare.setFont(new Font("Tahoma", Font.BOLD, 16));
    	add(lblShowfare);

    }
    
    public JComboBox getCBFrom() {
        return from;
    }

    public JComboBox getCBTo() {
        return to;
    }

    public JButton getBtnCalculateFare() {
        return btnCalculateFare;
    }

    public JLabel getLblShowfare() {
        return lblShowfare;
    }
}
