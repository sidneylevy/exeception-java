package enitities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	
	public long duration() {
		long res = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(res, TimeUnit.MILLISECONDS); // convertendo milsecundos para dias.
		
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for updatemust be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkin = checkIn;
		this.checkout = checkOut;
		return null;
		
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", checkin: "
				+ sdf.format(checkin)
				+ ", checkout: "
				+ sdf.format(checkin)
				+ ", "
				+ duration()
				+ " nights";
	}
}
