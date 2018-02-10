package model;

import java.util.LinkedList;

import javax.mail.MessagingException;

public class MainEmail {
	public static void main(String[] args) throws MessagingException {
		
	
	LinkedList<String> to = new LinkedList<String>();
	to.add("adrroguski@gmail.com");
	System.out.println(to.get(0));
	 EmailMessage wiadomosc = new EmailMessage.EmailBuilder("marek.czwartek@wp.pl",to )
			  .addSubject("Mail testowy")
			  .addContent("Brak tresci")
			  .build();
	 
	 wiadomosc.send("adrianroguski1990", "smtp.wp.pl", 465);
	} 
}
