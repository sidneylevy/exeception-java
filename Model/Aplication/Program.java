package Aplication;
import enitities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import enitities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException{

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date CheckIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date CheckOut = sdf.parse(sc.next());

		if (!CheckOut.after(CheckIn)) {
			System.out.println(" Errorin reservation: Check-out date must beaftercheck-in date");
		} else {
			Reservation reserva = new Reservation(number, CheckIn, CheckOut);
			System.out.println("Rservation: " + reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());
			
			String error = reserva.updateDates(CheckIn, CheckOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Rservation: " + reserva);
			}
				
			
		}
		
		

		sc.close();

	}

}
