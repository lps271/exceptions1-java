
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	// quando instaciamos o objeto sdf como estatico definimos que nao iremos criar
	// um novo objeto para cada reservation criada no programa principal
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // iremos usar este objeto para formatar
																				// as datas para dia, mes e ano

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

		long diff = checkOut.getTime() - checkIn.getTime(); // Aqui nós subtraimos o valor do checkin (entrada) do valor
															// do checkout (saida) e pegamos o valor em milisegundos.

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Aqui nos retornamos o valor de um metodo da
																	// TimeUnit que converte um valor em milissegundos
																	// para dias.
	}

	public String updateDate(Date checkIn, Date checkOut) {
		Date now = new Date(); // instanciamos um objeto do tipo Date com a data de hoje
		if (checkIn.before(now) || checkOut.before(now)) { // checamos se o se as datas novas inseridas são anteriores aos primeiro chekin e checkout
			return "Error in reservation: Reservation dates for update must be future dates";
		}else if (!checkOut.after(checkIn)) { // checamos nocamente se a data de checkout é superior á data de chekin,
												// caso não seja, informamos o erro.
			return "Error in reservation: Check-out date must be after check-in date";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", chek-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
