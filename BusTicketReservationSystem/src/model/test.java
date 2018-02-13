package model;

public class test {

    public static void main(String[] args) throws Exception {
	DataBaseModel db = new DataBaseModel ();
	db.createBusTimeTable();
	db.createTicketTable();
	//db.insertNewBus(100, "MZK Kety", "Mercedes121", null, "Kety", "7:00", "Pisarzowice", "8:00", 10);
	//db.insertNewBus(101, "MZK Kety", "Mercedes121", null, "Kety", "8:10", "Roczyny", "9:00", 10);
	
    }
}
