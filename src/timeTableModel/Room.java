package timeTableModel;

public class Room {

    private int id, maxStudentNumber;

    public Room(int roomId, int maxStudentsNumber) {
        this.id = roomId;
        this.maxStudentNumber = maxStudentsNumber;
    }

    public int getId() {
        return id;
    }

    public int getMaxStudentsNumber() {
        return maxStudentNumber;
    }

}
