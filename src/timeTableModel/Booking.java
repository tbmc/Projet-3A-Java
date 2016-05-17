/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;
import java.util.HashSet;

/**
 * Description of Booking.
 * 
 * @author tbmc
 */
public class Booking {
	/**
	 * Description of the property id.
	 */
	private int id = -1;

	/**
	 * Description of the property roomId.
	 */
	private int roomId = -1;

	/**
	 * Description of the property userLogin.
	 */
	private String userLogin = null;

	/**
	 * Description of the property dateBegin.
	 */
	private Date dateBegin = null;

	/**
	 * Description of the property dateEnd.
	 */
	private Date dateEnd = null;

	/**
	 * Returns id.
	 * @return id 
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Returns roomId.
	 * @return roomId 
	 */
	public int getRoomId() {
		return this.roomId;
	}

	/**
	 * Returns userLogin.
	 * @return userLogin 
	 */
	public String getUserLogin() {
		return this.userLogin;
	}

	/**
	 * Returns dateBegin.
	 * @return dateBegin 
	 */
	public Date getDateBegin() {
		return this.dateBegin;
	}

	/**
	 * Returns dateEnd.
	 * @return dateEnd 
	 */
	public Date getDateEnd() {
		return this.dateEnd;
	}

}
