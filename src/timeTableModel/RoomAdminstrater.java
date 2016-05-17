/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

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

	/**
	 * The constructor.
	 */
	public RoomAdminstrater() {
		super();
	}

	/**
	 * Description of the method addRoom.
	 * @param roomId 
	 * @param studentsNumber 
	 * @return 
	 */
	public Boolean addRoom(Integer roomId, Integer studentsNumber) {
		Boolean addRoom = Boolean.FALSE;
		return addRoom;
	}

	/**
	 * Description of the method removeRoom.
	 * @param roomId 
	 * @return 
	 */
	public Boolean removeRoom(Integer roomId) {
		Boolean removeRoom = Boolean.FALSE;
		return removeRoom;
	}

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
