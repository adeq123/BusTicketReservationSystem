package model;

public class test {

    public static void main(String[] args) throws Exception {
	DataBaseModel db = new DataBaseModel ();
	db.createBusTimeTable();
	db.createTicketTable();
    }
}
