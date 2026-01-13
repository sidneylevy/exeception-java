package enitities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Model.exepitions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkIn;
		this.checkout = checkOut;
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
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkin = checkIn;
		this.checkout = checkOut;
		
		
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
