package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	/*
	* Esta declara��o throws ParseException indica que existe um metodo que pode lan�ar uma exce��o dentro da implementa��o. 
	* Ou tratamos a exece��o interna ou adicionamos essa declara��o para dizer que a execss�o ser� lan�ada pelo metodo principal que a chamada est� sendo feita
	* (Neste caso o metodo main)
	*/
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//checamos se a data de checkout � superior � data de chekin, caso n�o seja, informamos o erro.
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			Date now = new Date(); //instanciamos um objeto do tipo Date com a data de hoje
			if (checkIn.before(now) || checkOut.before(now)) { //checamos se o se as datas novas inseridas s�o anteriores aos primeiro chekin e checkout
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) { //checamos nocamente se a data de checkout � superior � data de chekin, caso n�o seja, informamos o erro.
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else { 
				reservation.updateDate(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
			
			
		}
		
		
		sc.close();

	}

}
