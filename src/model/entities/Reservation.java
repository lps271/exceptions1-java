
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//quando instaciamos o objeto sdf como estatico definimos que nao iremos criar um novo objeto para cada reservation criada no programa principal
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //iremos usar este objeto para formatar as datas para dia, mes e ano
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	
	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime(); //Aqui nós subtraimos o valor do checkin (entrada) do valor do checkout (saida) e pegamos o valor em milisegundos.
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //Aqui nos retornamos o valor de um metodo da TimeUnit que converte um valor em milissegundos para dias.
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", chek-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
	
	

}
