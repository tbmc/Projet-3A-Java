package timeTableModel;

import org.jdom2.Element;
import utils.XMLToFileSaver;
import utils.XMLUtils;

import java.util.Hashtable;

public class TimeTableSaver {

    private String file = null;

    public final String
            ROOMS_NAME           = "Rooms",
            TIMETABLES_NAME      = "TimesTables"
    ;

    public TimeTableSaver(String file) {
        this.file = file;
    }

    public boolean load(Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        XMLToFileSaver in = new XMLToFileSaver(file);
        return decodeElements(in.loadFromFile(), rooms, timeTables);
    }

    public boolean save(Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        XMLToFileSaver out = new XMLToFileSaver(file);
        return out.saveToFile(domBuild(rooms, timeTables));
    }

    private Element domBuild(Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        Element root = new Element("TimeTableDB");
        root.addContent(XMLUtils.getXMLFromHashTable(ROOMS_NAME, rooms))
            .addContent(XMLUtils.getXMLFromHashTable(TIMETABLES_NAME, timeTables));
        return root;
    }

    private boolean decodeElements(Element e, Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        boolean b = false;
        Room r = new Room();
        rooms.clear();
        timeTables.clear();
        b = XMLUtils.getFromElement(e.getChild(ROOMS_NAME), rooms, new Room());
        if(!b) return false;
        b = XMLUtils.getFromElement(e.getChild(TIMETABLES_NAME), timeTables, new TimeTable(), rooms);
        if(!b) return false;

        return b;
    }


}
