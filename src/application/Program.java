
package application;
import model.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws ParseException{
       Locale.setDefault(Locale.US);
       Scanner scanner = new Scanner(System.in);
       SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
       
       //Atributes 
       int number;
       Date checkIn;
       Date checkOut;
       Date now;
       
       
       System.out.println("Room number: ");
       number = scanner.nextInt();
       System.out.println("Check-in date (dd/mm/yyyy): ");
       checkIn = sdf.parse(scanner.next());
       System.out.println("Check-out date (dd/mm/yyyy): ");
       checkOut = sdf.parse(scanner.next());
       
       if(!checkOut.after(checkIn)){
           System.out.println("Error in reservation: Check-out date must be after check-in date");
       }else{
           Reservation reservation = new Reservation(number,checkIn,checkOut);
           System.out.println("Reservation: "+reservation);
           
           System.out.println();
           System.out.println("Enter data to update the reservation");
           System.out.println("Check-in date (dd/mm/yyyy): ");
           checkIn = sdf.parse(scanner.next());
           System.out.println("Check-out date (dd/mm/yyyy): ");
           checkOut = sdf.parse(scanner.next());
           
           now = new Date();
           if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for updates must be future dates");
           }else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
           }else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: "+reservation);
           }
           
          
           
         
       }
               
       
       
       scanner.close();
    }
}
