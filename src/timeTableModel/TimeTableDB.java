package timeTableModel;

import java.sql.Time;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 
 * Cette classe gére la base de données d'emplois du temps. Elle doit permettre de sauvegarder et charger les emplois du temps ainsi que les salles à partir d'un fichier XML. 
 * La structure du fichier XML devra être la même que celle du fichier TimeTableDB.xml.
 * @see <a href="../../TimeTableDB.xml">TimeTableDB.xml</a> 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class TimeTableDB {
	/**
	 * 
	 * Le fichier contenant la base de données.
	 * 
	 */
	private String file;

    private Hashtable<Integer, Room> rooms = new Hashtable<>();
    private Hashtable<Integer, TimeTable> timeTables = new Hashtable<>();


	/**
	 * 
	 * Constructeur de TimeTableDB. 
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public TimeTableDB(String file){
		//TODO À modifier
		super();
		this.setFile(file);
	}
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public String getFile() {
		return file;
	}
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	public void setFile(String file) {
		this.file = file;
	}

    public boolean saveDB() {
        // TODO Implémenter ça
        return false;
    }

    public boolean loadDB() {
        // TODO Implémenter ça
        return false;
    }







	public boolean addRoom(int roomId, int maxStudentsNumber) {
        if(rooms.containsKey(roomId))
            return false;
        rooms.put(roomId, new Room(roomId, maxStudentsNumber));
		return true;
	}

	public boolean removeRoom(int roomId) {
        return rooms.remove(roomId) != null;
	}

    public int getRoomId(int timeTableId, int bookId) {
        return timeTables.get(timeTableId).getRoom(bookId);
    }

    public String[] roomsIdToString() {
        return TimeTableDB.idKeysToStringArray(rooms);
    }






    public boolean addTimeTable(int timeTableId) {
        if(timeTables.containsKey(timeTableId))
            return false;
        timeTables.put(timeTableId, new TimeTable(timeTableId));
        return true;
    }

    public boolean removeTimeTable(int timeTableId) {
        return timeTables.remove(timeTableId) != null;
    }

    public String[] timeTablesIDToString() {
        return TimeTableDB.idKeysToStringArray(timeTables);
    }



    public boolean addBooking(int timeTableId, int bookingId, String login, Date dateBegin, Date dateEnd, int roomId) {
        Room room = rooms.get(roomId);
        TimeTable tt = timeTables.get(timeTableId);
        if(tt == null || room == null)
            return false;
        return tt.addBooking(bookingId, login, dateBegin, dateEnd, room);
    }

    public boolean removeBook(int timeTableId, int bookId) {
        return timeTables.remove(timeTableId) != null;
    }

    public void getBookingsDate(int timeTableId, Hashtable<Integer, Date> dateBegin, Hashtable<Integer, Date> dateEnd) {
        TimeTable tt = timeTables.get(timeTableId);
        if(tt == null)
            return;
        tt.getBookingsDate(dateBegin, dateEnd);
    }

    public int getBookingsMaxId(int timeTableId) {
        TimeTable tt = timeTables.get(timeTableId);
        if(tt == null)
            return 0; // On ne retourne pas vraiment une erreur, renvoyer 0 permet d'ajouter directement à cet index
        return tt.getBookinsMaxId();
    }

    public String getUserLogin(int timeTableId, int bookId) {
        TimeTable tt = timeTables.get(timeTableId);
        if(tt == null)
            return null;
        return tt.getUserLogin(bookId);
    }

    public String[] booksIdToString(int timeTableId) {
        TimeTable tt = timeTables.get(timeTableId);
        if(tt == null)
            return null;
        return tt.idToString();
    }










    public static String[] idKeysToStringArray(Hashtable<Integer, ?> in) {
        int size = in.size();
        String[] str = new String[size];
        Enumeration<Integer> keys = in.keys();
        for(Integer i = 0, k = 0; keys.hasMoreElements(); i++, k = keys.nextElement()) {
            str[i] = k.toString();
        }
        return str;
    }


}
