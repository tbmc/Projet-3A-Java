package timeTableModel;

import org.jdom2.Element;
import utils.XMLUtils;

public class Room implements XMLUtils.XMLSerializable {

    private int id, maxStudentNumber;

    public Room(int roomId, int maxStudentsNumber) {
        this.id = roomId;
        this.maxStudentNumber = maxStudentsNumber;
    }

    Room() {
        this(-1, 0);
    }

    public int getId() {
        return id;
    }

    public int getMaxStudentsNumber() {
        return maxStudentNumber;
    }

    public String getInfo() {
        return id + ";" + maxStudentNumber;
    }

    @Override
    public Element getXMLElement() {
        Element e = new Element(getXML_NAME()),
                rid = new Element(getXML_INNER_ID()),
                rcp = new Element("Capacity");
        rid.setText("" + id);
        rcp.setText("" + maxStudentNumber);
        e.addContent(rid);
        e.addContent(rcp);
        return e;
    }

    @Override
    public Room createFromXMLElement(Element e, Object params) {
        Integer a, b;

        try {
            a = Integer.parseInt(e.getChildText(getXML_INNER_ID()));
            b = Integer.parseInt(e.getChildText("Capacity"));
        }
        catch(NumberFormatException exc) {
            exc.printStackTrace();
            return null;
        }

        return new Room(a, b);
    }

    @Override
    public String getXML_NAME() { return "Room"; }
    @Override
    public String getXML_INNER_ID() { return "RoomId"; }

}
