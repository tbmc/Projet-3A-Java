/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Booking.
 * 
 * @author tbmc
 */
public class Booking {
	/**
	 * Description of the property id.
	 */
	private HashSet<Integer> id = new HashSet<Integer>();

	/**
	 * Description of the property roomId.
	 */
	private HashSet<Integer> roomId = new HashSet<Integer>();

	/**
	 * Description of the property userLogin.
	 */
	private HashSet<String> userLogin = new HashSet<String>();

	/**
	 * Description of the property dateBegin.
	 */
	private HashSet<Date> dateBegin = new HashSet<Date>();

	/**
	 * Description of the property dateEnd.
	 */
	private HashSet<Date> dateEnd = new HashSet<Date>();

	// Start of user code (user defined attributes for Booking)

	// End of user code

	// Start of user code (user defined methods for Booking)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public HashSet<Integer> getId() {
		return this.id;
	}

	/**
	 * Returns roomId.
	 * @return roomId 
	 */
	public HashSet<Integer> getRoomId() {
		return this.roomId;
	}

	/**
	 * Returns userLogin.
	 * @return userLogin 
	 */
	public HashSet<String> getUserLogin() {
		return this.userLogin;
	}

	/**
	 * Returns dateBegin.
	 * @return dateBegin 
	 */
	public HashSet<Date> getDateBegin() {
		return this.dateBegin;
	}

	/**
	 * Returns dateEnd.
	 * @return dateEnd 
	 */
	public HashSet<Date> getDateEnd() {
		return this.dateEnd;
	}

}
