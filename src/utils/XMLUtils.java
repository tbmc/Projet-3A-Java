package utils;

import org.jdom2.Element;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class XMLUtils {

    public interface XMLSerializable extends Serializable {

        Element getXMLElement();

        String getXML_NAME();
        String getXML_INNER_ID();

        <T extends XMLSerializable> T createFromXMLElement(Element e, Object params);

    }

    public static Element getXMLFromHashTable(String xmlName, Hashtable<Integer, ? extends XMLSerializable> in) {
        Element e = new Element(xmlName);
        Enumeration<Integer> keys = in.keys();
        while(keys.hasMoreElements()) {
            e.addContent(in.get(keys.nextElement()).getXMLElement());
        }
        return e;
    }

    public static <T extends XMLSerializable> boolean getFromElement(Element e, Hashtable<Integer, T> out, XMLSerializable s) {
        return getFromElement(e, out, s, null);
    }

    public static <T extends XMLSerializable> boolean getFromElement(Element e, Hashtable<Integer, T> out, XMLSerializable s,  Object params) {

        if(s.getXML_NAME() == null || s.getXML_INNER_ID() == null)
            return false;
        Iterator<Element> i = e.getChildren(s.getXML_NAME()).iterator();
        Integer id;
        T newClass;
        while(i.hasNext()) {
            Element n = i.next();
            id = Integer.parseInt(n.getChildText(s.getXML_INNER_ID()));
            newClass = s.createFromXMLElement(n, params);
            if(id == null || newClass == null)
                return false;
            out.put(id, newClass);
        }
        return true;

    }

    public static String md5(String in) {
        String out = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(in.getBytes());
            out = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return out;
    }

}
