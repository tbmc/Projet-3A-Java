/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

/**
 * Description of Room.
 * 
 * @author tbmc
 */
public class Room {
	/**
	 * Description of the property id.
	 */
	private int id = -1;

	/**
	 * Description of the property studentsNumber.
	 */
	private int studentsNumber = -1;

	/**
	 * Returns id.
	 * @return id 
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Returns studentsNumber.
	 * @return studentsNumber 
	 */
	public int getStudentsNumber() {
		return this.studentsNumber;
	}

    public Room(int roomId, int studentsNumber) {
        this.id = roomId;
        this.studentsNumber = studentsNumber;
    }

}
