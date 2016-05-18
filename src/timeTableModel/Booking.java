package timeTableModel;

import java.util.Date;

public class Booking {

    private int id;
    private Room room;
    private String userLogin;
    private Date dateBegin, dateEnd;

    public Booking(int bookingId, Room room, String userLogin,
                   Date dateBegin, Date dateEnd) {
        this.id = bookingId;
        this.room = room;
        this.userLogin = userLogin;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

}
