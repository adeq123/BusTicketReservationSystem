package model;

import controller.Controller;

public class test {

    public static void main(String[] args) throws Exception {
	DataBaseModel db = new DataBaseModel ();
	Controller ctrl = new Controller();
	
	System.out.println(ctrl.getUniqueID());
	System.out.println(ctrl.getUniqueID());
    }
}
