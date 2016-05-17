/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
import java.util.HashSet;

/**
 * Description of TimeTable.
 * 
 * @author tbmc
 */
public class TimeTable {
	/**
	 * Description of the property id.
	 */
	public int id = -1;

	/**
	 * Description of the property bookings.
	 */
	public Booking bookings = null;

	/**
	 * Description of the method addBooking.
	 * @param bookingId 
	 * @param loginUser 
	 * @param dateBegin 
	 * @param dateEnd 
	 * @param roomId 
	 * @return 
	 */
	public Boolean addBooking(Integer bookingId, String loginUser, Date dateBegin, Date dateEnd, Integer roomId) {
		Boolean addBooking = Boolean.FALSE;
		return addBooking;
	}

	/**
	 * Description of the method removeBooking.
	 * @param bookId 
	 * @return 
	 */
	public Boolean removeBooking(Integer bookId) {
		Boolean removeBooking = Boolean.FALSE;
		return removeBooking;
	}

	/**
	 * Returns id.
	 * @return id 
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Returns bookings.
	 * @return bookings 
	 */
	public Booking getBookings() {
		return this.bookings;
	}

	/**
	 * Sets a value to attribute bookings. 
	 * @param newBookings 
	 */
	public void setBookings(Booking newBookings) {
		this.bookings = newBookings;
	}

}
