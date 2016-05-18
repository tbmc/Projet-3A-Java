package timeTableModel;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class TimeTable {

    private int id;
    private Hashtable<Integer, Booking> bookings = new Hashtable<>();

    public TimeTable(int bookingId) {
        this.id = bookingId;
    }

    public boolean addBooking(int bookingId, String userLogin, Date dateBegin, Date dateEnd, Room room) {
        if(bookings.containsKey(bookingId))
            return false;
        bookings.put(bookingId, new Booking(bookingId, room, userLogin, dateBegin, dateEnd));
        return true;
    }

    public boolean removeBooking(int bookingId) {
        return bookings.remove(bookingId) != null;
    }

    public int getRoom(int bookId) {
        return bookings.get(bookId).getRoom().getId();
    }

    public void getBookingsDate(Hashtable<Integer, Date> dateBegin, Hashtable<Integer, Date> dateEnd) {
        Enumeration<Integer> keys = bookings.keys();
        int v;
        Booking b;
        while(keys.hasMoreElements()) {
            v = keys.nextElement();
            b = bookings.get(v);
            dateBegin.put(v, b.getDateBegin());
            dateEnd.put(v, b.getDateEnd());
        }
    }

    public int getBookinsMaxId() {
        Enumeration<Integer> keys = bookings.keys();
        int max = 0, v;
        while(keys.hasMoreElements()) {
            v = keys.nextElement();
            if(v > max)
                max = v;
        }
        return max;
    }

    public String getUserLogin(int bookId) {
        Booking book = bookings.get(bookId);
        if(book == null)
            return null;
        return book.getUserLogin();
    }

    public String[] idToString() {
        return TimeTableDB.idKeysToStringArray(bookings);
    }

}
