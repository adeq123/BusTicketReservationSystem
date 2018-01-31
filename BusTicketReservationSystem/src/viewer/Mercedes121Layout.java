package viewer;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.util.LinkedList;

public class Mercedes121Layout extends JPanel implements BusLayout{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * This is a general class for building bus seats layouts of different types
     */
    private LinkedList<JToggleButton> seatButtons;

    public Mercedes121Layout() {

	setBorder(new LineBorder(new Color(255, 0, 0), 3, true));
	setLayout(null);

	JToggleButton seat1 = new JToggleButton("");
	seat1.setName("seat1");
	seat1.setToolTipText("");
	seat1.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat1.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat1.setBounds(10, 27, 35, 32);
	add(seat1);

	JToggleButton seat4 = new JToggleButton("");
	seat4.setName("seat4");
	seat4.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat4.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat4.setToolTipText("");
	seat4.setBounds(55, 27, 35, 32);
	add(seat4);

	JToggleButton seat7 = new JToggleButton("");
	seat7.setName("seat7");
	seat7.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat7.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat7.setToolTipText("");
	seat7.setBounds(100, 27, 35, 32);
	add(seat7);

	JToggleButton seat10 = new JToggleButton("");
	seat10.setName("seat10");
	seat10.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat10.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat10.setToolTipText("");
	seat10.setBounds(145, 27, 35, 32);
	add(seat10);

	JToggleButton seat13 = new JToggleButton("");
	seat13.setName("seat13");
	seat13.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat13.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat13.setToolTipText("");
	seat13.setBounds(190, 27, 35, 32);
	add(seat13);

	JToggleButton seat16 = new JToggleButton("");
	seat16.setName("seat15");
	seat16.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat16.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat16.setToolTipText("");
	seat16.setBounds(235, 27, 35, 32);
	add(seat16);

	JToggleButton seat19 = new JToggleButton("");
	seat19.setName("seat19");
	seat19.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat19.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat19.setToolTipText("");
	seat19.setBounds(280, 27, 35, 32);
	add(seat19);

	JToggleButton seat22 = new JToggleButton("");
	seat22.setName("seat22");
	seat22.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat22.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat22.setToolTipText("");
	seat22.setBounds(325, 27, 35, 32);
	add(seat22);

	JToggleButton seat25 = new JToggleButton("");
	seat25.setName("seat25");
	seat25.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat25.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat25.setToolTipText("");
	seat25.setBounds(370, 27, 35, 32);
	add(seat25);

	JToggleButton seat28 = new JToggleButton("");
	seat28.setName("seat28");
	seat28.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat28.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat28.setToolTipText("");
	seat28.setBounds(415, 27, 35, 32);
	add(seat28);

	JToggleButton seat29 = new JToggleButton("");
	seat29.setName("seat29");
	seat29.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat29.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat29.setToolTipText("");
	seat29.setBounds(415, 70, 35, 32);
	add(seat29);

	JToggleButton seat26 = new JToggleButton("");
	seat26.setName("seat26");
	seat26.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat26.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat26.setToolTipText("");
	seat26.setBounds(370, 70, 35, 32);
	add(seat26);

	JToggleButton seat23 = new JToggleButton("");
	seat23.setName("seat23");
	seat23.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat23.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat23.setToolTipText("");
	seat23.setBounds(325, 70, 35, 32);
	add(seat23);

	JToggleButton seat20 = new JToggleButton("");
	seat20.setName("seat20");
	seat20.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat20.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat20.setToolTipText("");
	seat20.setBounds(280, 70, 35, 32);
	add(seat20);

	JToggleButton seat17 = new JToggleButton("");
	seat17.setName("seat17");
	seat17.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat17.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat17.setToolTipText("");
	seat17.setBounds(235, 70, 35, 32);
	add(seat17);

	JToggleButton seat14 = new JToggleButton("");
	seat14.setName("seat14");
	seat14.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat14.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat14.setToolTipText("");
	seat14.setBounds(190, 70, 35, 32);
	add(seat14);

	JToggleButton seat11 = new JToggleButton("");
	seat11.setName("seat11");
	seat11.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat11.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat11.setToolTipText("");
	seat11.setBounds(145, 70, 35, 32);
	add(seat11);

	JToggleButton seat8 = new JToggleButton("");
	seat8.setName("seat8");
	seat8.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat8.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat8.setToolTipText("");
	seat8.setBounds(100, 70, 35, 32);
	add(seat8);

	JToggleButton seat5 = new JToggleButton("");
	seat5.setName("seat5");
	seat5.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat5.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat5.setToolTipText("");
	seat5.setBounds(55, 70, 35, 32);
	add(seat5);

	JToggleButton seat2 = new JToggleButton("");
	seat2.setName("seat2");
	seat2.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat2.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat2.setToolTipText("");
	seat2.setBounds(10, 70, 35, 32);
	add(seat2);

	JToggleButton seat30 = new JToggleButton("");
	seat30.setName("seat30");
	seat30.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat30.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat30.setToolTipText("1");
	seat30.setBounds(415, 153, 35, 32);
	add(seat30);

	JToggleButton seat27 = new JToggleButton("");
	seat27.setName("seat27");
	seat27.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat27.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat27.setToolTipText("");
	seat27.setBounds(370, 153, 35, 32);
	add(seat27);

	JToggleButton seat24 = new JToggleButton("");
	seat24.setName("seat24");
	seat24.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat24.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat24.setToolTipText("");
	seat24.setBounds(325, 153, 35, 32);
	add(seat24);

	JToggleButton seat21 = new JToggleButton("");
	seat21.setName("seat21");
	seat21.setName("seat21");
	seat21.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat21.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat21.setToolTipText("");
	seat21.setBounds(280, 153, 35, 32);
	add(seat21);

	JToggleButton seat18 = new JToggleButton("");
	seat18.setName("seat18");
	seat18.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat18.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat18.setToolTipText("");
	seat18.setBounds(235, 153, 35, 32);
	add(seat18);

	JToggleButton seat15 = new JToggleButton("");
	seat15.setName("seat15");
	seat15.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat15.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat15.setToolTipText("");
	seat15.setBounds(190, 153, 35, 32);
	add(seat15);

	JToggleButton seat12 = new JToggleButton("");
	seat12.setName("seat12");
	seat12.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat12.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat12.setToolTipText("");
	seat12.setBounds(145, 153, 35, 32);
	add(seat12);

	JToggleButton seat9 = new JToggleButton("");
	seat9.setName("seat9");
	seat9.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat9.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat9.setToolTipText("");
	seat9.setBounds(100, 153, 35, 32);
	add(seat9);

	JToggleButton seat6 = new JToggleButton("");
	seat6.setName("seat6");
	seat6.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat6.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat6.setToolTipText("");
	seat6.setBounds(55, 153, 35, 32);
	add(seat6);

	JToggleButton seat3 = new JToggleButton("");
	seat3.setName("seat3");
	seat3.setSelectedIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/occupiedSeat.png")));
	seat3.setIcon(new ImageIcon(Mercedes121Layout.class.getResource("/viewer/freeSeat.png")));
	seat3.setToolTipText("");
	seat3.setBounds(10, 153, 35, 32);
	add(seat3);
	
    }
    /**
     * @see BusLayout interface
     */
    public LinkedList<JToggleButton> getAllSeatButtons(){
	seatButtons = new LinkedList<JToggleButton>();
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seatButtons.add((JToggleButton)comp[i]);
	    }
	}
	return seatButtons;

    }
    /**
     * @see BusLayout interface
     */
    public JToggleButton getSelectedSeat(String seatName){
	JToggleButton seat;
	Component[] comp = this.getComponents();
	for (int i = 0;i<comp.length;i++) {
	    if (comp[i] instanceof JToggleButton) {
		seat = (JToggleButton)comp[i];
		if(seat.getName().equals(seatName)){
		    return (JToggleButton)comp[i];
		}
	    }
	}
	return null;

    }
}
