# BusTicketReservationSystem

Download this project from: https://github.com/adeq123/BusTicketReservationSystem

## Motivation
This project was made to practice and show my practical knoledge of JAVA SE, MySQL(basic stuff), Swing, Javadoc and MVC pattern. The goal is to include the project in my portfolio and at my professional webpage.

## General description
The application allows to book a ticket from one place to desired destination. It shows you the bus layout and allows you to choose the seat. Afterwards the ticket is printed to pdf and confirmation is send to passengers e-mail adress. Afterwards the ticket is added to MYSQL database. The ticket table can managed / updated by mean of given graphical interface. Moreover you can add new routes to the program. Appropriate GUI is provided. User can add / delete / update / view all of the routes. Administration panel is provided where adminstration can view / add / delete users.
## Detailed description & features
### Login & Administration
To open the application you have to be registered user or admin and enter correct login / password pair.
![](BusTicketReservationSystem/readme%20images/login.png)

If incorrect login / password is entered then appropriate infromation is shown and you can try again.
![](BusTicketReservationSystem/readme%20images/login%20incorrect.png)

If you enter correct credentials you will get info about that and the application will start.
![](BusTicketReservationSystem/readme%20images/log%20correct.png)

The administrator can manage users in Administration tab. To show hidden admin tools you have to know the password which is hard typed in the system. After you do that the tools shows up. You can view all of the users, add and delete them.

![](BusTicketReservationSystem/readme%20images/Administration.png)

![](BusTicketReservationSystem/readme%20images/Administration2.png)

### Ticket Reservation

One of the main purposes of this application is ticket booking. The reservation starts with selection of source and destination city. Afterwards you should enter the travel date and click Get Bus Details. Then you can select the specific bus you would like to travel or click Reset to regret and go back.  

![](BusTicketReservationSystem/readme%20images/reservation1.png)

After selecting the bus the user should select Load. As a consequence of that the bus layout shows up. To move forward the user needs to select the seat by direct click on the seat we would like to have. If no bus is selected the information about that is shown and you cannot move further. 
![](BusTicketReservationSystem/readme%20images/reservation2.png)
![](BusTicketReservationSystem/readme%20images/reservation3.png)

After selecting the seat the user needs to click make reservation and booking details shows up. To continue name, mobile and e-mail needs to be entered. User can undo the reservation by clicing Cancel. After clicing the Submit the ticket is printed to the PDF file. The user needs to show the location where ticket will be saved. Moreover the passenger will get confirmation on his e-mail adress. The email is send using SSL protocol.

![](BusTicketReservationSystem/readme%20images/reservation4.png)
![](BusTicketReservationSystem/readme%20images/reservation5.png)
![](BusTicketReservationSystem/readme%20images/reservation6.png)

### Bus Management
The second most important feature is possbility to add a new route. To do that the user needs to simply fill in the form and press add. Additionally you can view, delete and update the existing routs. The Fetch button is available to fill in the form with the data from existing record. You just select the record in the table and press fetch.
![](BusTicketReservationSystem/readme%20images/BusMana.png)

### Ticket Management
Ticket management tab allows user to:
- update the passenger info
- delete the ticket based on ticket number
- print ticket to pdf and send confirmation to passenger
- view all of the sold tickets
The Fetch button is available to fill in the form with the data from existing record. You just select the record in the table and press fetch
![](BusTicketReservationSystem/readme%20images/ticketmana.png)

### Fare calculator
A simple tool to calcualte the ticket price between two places. Simply select the source and destiantion and press Calcualte Fare.
![](BusTicketReservationSystem/readme%20images/farecalc.png)

## Concepts used:
Java SE, MySQL, JavaMail, Javadoc, Swing, AWT, MVC, Builder pattern, PDF generation.  
Core datastructures used: Arrays, LinkedList, Hashsets.  
File Handling - reading / writing to txt file. PDF generation. E-Mail senind with SSL protocol.

## Author
Adrian Roguski with inspiration from http://www.lovelycoding.org (100% of coding was done by author though).
