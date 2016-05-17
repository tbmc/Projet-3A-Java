/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Room.
 * 
 * @author tbmc
 */
public class Room {
	/**
	 * Description of the property id.
	 */
	private HashSet<Integer> id = new HashSet<Integer>();

	/**
	 * Description of the property studentsNumber.
	 */
	private HashSet<Integer> studentsNumber = new HashSet<Integer>();

	// Start of user code (user defined attributes for Room)

	// End of user code

	// Start of user code (user defined methods for Room)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public HashSet<Integer> getId() {
		return this.id;
	}

	/**
	 * Returns studentsNumber.
	 * @return studentsNumber 
	 */
	public HashSet<Integer> getStudentsNumber() {
		return this.studentsNumber;
	}

}
