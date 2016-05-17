/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimeTable.
 * 
 * @author tbmc
 */
public class TimeTable {
	/**
	 * Description of the property id.
	 */
	public HashSet<Integer> id = new HashSet<Integer>();

	/**
	 * Description of the property bookings.
	 */
	public Booking bookings = null;

	// Start of user code (user defined attributes for TimeTable)

	// End of user code

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
		// Start of user code for method addBooking
		Boolean addBooking = Boolean.FALSE;
		return addBooking;
		// End of user code
	}

	/**
	 * Description of the method removeBooking.
	 * @param bookId 
	 * @return 
	 */
	public Boolean removeBooking(Integer bookId) {
		// Start of user code for method removeBooking
		Boolean removeBooking = Boolean.FALSE;
		return removeBooking;
		// End of user code
	}

	// Start of user code (user defined methods for TimeTable)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public HashSet<Integer> getId() {
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
