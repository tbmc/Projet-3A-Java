package timeTableModel;

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
	private String file = null;

    private Hashtable<Integer, Room> rooms = new Hashtable<>();
    private Hashtable<Integer, TimeTable> timeTables = new Hashtable<>();


    private TimeTableSaver timeTableSaver = new TimeTableSaver(file);
    private TimeTableSaver.SavedState hashLastCommit = null;

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
        timeTableSaver.setFile(file);
	}

    public boolean saveDB(String file) {
        timeTableSaver.setFile(file);
        return timeTableSaver.save(rooms, timeTables, hashLastCommit);
    }

    public boolean saveDB() {
        return saveDB(file);
    }

    public boolean loadDB() {
        TimeTableSaver.SavedState ss = timeTableSaver.load(rooms, timeTables);
        this.hashLastCommit = ss;
        return ss != null;
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

    public String[] roomsToString() {
        Enumeration<Integer> keys = rooms.keys();
        String[] out = new String[rooms.size()];
        for(Integer i = 0, k = 0; keys.hasMoreElements(); i++, k = keys.nextElement()) {
            out[i] = rooms.get(k).getInfo();
        }
        return out;
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
        if(!isRoomFree(roomId, dateBegin, dateEnd))
            return false;
        return tt.addBooking(bookingId, login, dateBegin, dateEnd, room);
    }

    public boolean isRoomFree(int roomId, Date begin, Date end) {
        Enumeration<Integer> keys = timeTables.keys();
        while(keys.hasMoreElements()) {
            TimeTable tt = timeTables.get(keys.nextElement());
            if(!tt.isRoomFree(roomId, begin, end))
                return false;
        }
        return true;
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
        return tt.getBookingsMaxId();
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
