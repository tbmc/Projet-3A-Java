/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of RoomAdminstrater.
 * 
 * @author tbmc
 */
public class RoomAdminstrater {
	/**
	 * Description of the property rooms.
	 */
	public Room rooms = null;

	// Start of user code (user defined attributes for RoomAdminstrater)

	// End of user code

	/**
	 * The constructor.
	 */
	public RoomAdminstrater() {
		// Start of user code constructor for RoomAdminstrater)
		super();
		// End of user code
	}

	/**
	 * Description of the method addRoom.
	 * @param roomId 
	 * @param studentsNumber 
	 * @return 
	 */
	public Boolean addRoom(Integer roomId, Integer studentsNumber) {
		// Start of user code for method addRoom
		Boolean addRoom = Boolean.FALSE;
		return addRoom;
		// End of user code
	}

	/**
	 * Description of the method removeRoom.
	 * @param roomId 
	 * @return 
	 */
	public Boolean removeRoom(Integer roomId) {
		// Start of user code for method removeRoom
		Boolean removeRoom = Boolean.FALSE;
		return removeRoom;
		// End of user code
	}

	// Start of user code (user defined methods for RoomAdminstrater)

	// End of user code
	/**
	 * Returns rooms.
	 * @return rooms 
	 */
	public Room getRooms() {
		return this.rooms;
	}

	/**
	 * Sets a value to attribute rooms. 
	 * @param newRooms 
	 */
	public void setRooms(Room newRooms) {
		this.rooms = newRooms;
	}

}
