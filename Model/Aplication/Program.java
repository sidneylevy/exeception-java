package Aplication;
import enitities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.exepitions.DomainException;
import enitities.Reservation;

public class Program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date CheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date CheckOut = sdf.parse(sc.next());
	
			Reservation reserva = new Reservation(number, CheckIn, CheckOut);
			System.out.println("Rservation: " + reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());
			
			reserva.updateDates(CheckIn, CheckOut);
			System.out.println("Rservation: " + reserva);
		}
		catch (ParseException e){
			System.out.println("Invalid date format!");
		}
		catch (DomainException e) {
			System.err.println("Error in reservation: " + e.getMessage());
		}
		
		
		

		sc.close();

	}

}
