package timeTableModel;

import org.jdom2.Element;
import utils.XMLUtils;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class TimeTable implements XMLUtils.XMLSerializable {

    private int id;
    private Hashtable<Integer, Booking> bookings = new Hashtable<>();

    private static final String
            XML_NAME        = "TimeTable",
            XML_INNER_ID    = "GroupId";

    TimeTable() {
        this(-1);
    }

    public TimeTable(int bookingId) {
        this(bookingId, null);
    }

    TimeTable(int bookingId, Hashtable<Integer, Booking> bookings) {
        this.id = bookingId;
        if(bookings != null)
            this.bookings = bookings;

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

    public int getBookingsMaxId() {
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

    @Override
    public Element getXMLElement() {
        Element e = new Element(XML_NAME);

        Element gid = new Element(XML_INNER_ID);
        gid.setText("" + id);
        e.addContent(gid);

        e.addContent(XMLUtils.getXMLFromHashTable("Books", bookings));

        return e;
    }

    @Override
    public String getXML_NAME() {
        return XML_NAME;
    }

    @Override
    public String getXML_INNER_ID() {
        return XML_INNER_ID;
    }

    public TimeTable createFromXMLElement(Element e, Object params) {
        Hashtable<Integer, Room> rooms = (Hashtable<Integer, Room>) params;
        Integer id = Integer.parseInt(e.getChildText(XML_INNER_ID));
        Hashtable<Integer, Booking> bookings = new Hashtable<>();
        boolean b = XMLUtils.getFromElement(e.getChild("Books"), bookings, new Booking(), rooms);
        if(!b) return null;
        return new TimeTable(id, bookings);
    }

}
