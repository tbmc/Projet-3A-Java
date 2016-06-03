package timeTableModel;

import org.jdom2.Element;
import utils.XMLToFileSaver;
import utils.XMLUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeTableSaver {

    private String file = null;

    public final String
            ROOMS_NAME           = "Rooms",
            TIMETABLES_NAME      = "TimesTables",

            LAST_COMMIT          = "LastCommit",
            COMMIT_HASH          = "Hash",
            COMMIT_DATE          = "Date",
            DATE_FORMAT          = "dd/MM/yyyy HH:mm:ss"
    ;

    public TimeTableSaver(String file) {
        this.file = file;
    }

    public SavedState load(Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        System.out.println(file);
        XMLToFileSaver in = new XMLToFileSaver(file);
        Element e = in.loadFromFile();
        SavedState ss = getLastCommit(e);

        boolean b = decodeElements(e, rooms, timeTables);
        return b ? ss : null;
    }

    public boolean save(Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables, SavedState ssOld) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        String date = df.format(new Date());
        String hash = XMLUtils.md5(System.currentTimeMillis() + date);
        Element e = new Element(LAST_COMMIT),
                ch = new Element(COMMIT_HASH),
                cd = new Element(COMMIT_DATE);
        cd.setText(date);
        ch.setText(hash);
        e.addContent(ch);
        e.addContent(cd);

        XMLToFileSaver out = new XMLToFileSaver(file);
        Element old = out.loadFromFile();
        Element dom = domBuild(rooms, timeTables);
        dom.addContent(e);

        boolean b = false;
        if(file != null && ssOld != null && file.equals(ssOld.getFilePath())) {
            SavedState ss = getLastCommit(old);
            if(!ss.getHash().equals(ssOld.getHash())) {
                b = true;
            }
        }

        if(b) {
            // Ici, il y a un conflit
            System.out.println("Ecraser le fichier précédent.");
            System.out.println("Oui (O) ou Non (N) ?");
            Scanner scan = new Scanner(System.in);
            String inStr = scan.nextLine();
            Character c = Character.toUpperCase(inStr.charAt(0));
            if(c == '0') {
                System.out.println("Le fichier va être écrasé.");
                return out.saveToFile(dom);
            }
            else {
                System.out.println("Le fichier n'a pas été enregistré.");
                return false;
            }
        }
        else {
            // Ici il n'y a pas de conflit
            return out.saveToFile(dom);
        }
    }

    /*
    protected LinkedList<String> getDiff(Element old, Element newE) {
        LinkedList<String> ll = new LinkedList<>();

        List<Element> l = newE.getChildren();
        for(Element e : l) {
            String name = e.getName();

        }
        return ll;
    }
    */

    protected SavedState getLastCommit() {
        return getLastCommit(null);
    }
    protected SavedState getLastCommit(Element e) {
        if(e == null) {
            XMLToFileSaver in = new XMLToFileSaver(file);
            e = in.loadFromFile();
        }
        if(e == null) return null;
        Element commit = e.getChild(LAST_COMMIT);
        SavedState ss = new SavedState(file, commit.getChildText(COMMIT_HASH));
        return ss;
    }

    private Element domBuild(Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        Element root = new Element("TimeTableDB");
        root.addContent(XMLUtils.getXMLFromHashTable(ROOMS_NAME, rooms))
                .addContent(XMLUtils.getXMLFromHashTable(TIMETABLES_NAME, timeTables));
        return root;
    }

    public void setFile(String file) {
        this.file = file;
    }

    private boolean decodeElements(Element e, Hashtable<Integer, Room> rooms, Hashtable<Integer, TimeTable> timeTables) {
        if(e == null)
            return false;
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

    public class SavedState {
        private String filePath, hash;
        public SavedState(String filePath, String hash) {
            this.filePath = filePath;
            this.hash = hash;
        }
        @Override
        public boolean equals(Object o) {
            if(!(o instanceof SavedState))
                return false;
            return filePath.equals(((SavedState) o).filePath) &&
                    hash.equals(((SavedState) o).hash);
        }
        public String getFilePath() {
            return filePath;
        }
        public String getHash() {
            return hash;
        }
    }

}