package utils;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLToFileSaver {

    private String file = null;

    public XMLToFileSaver(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public boolean saveToFile(Element root) {
        boolean outBool = false;
        try {
            Document dom = new Document(root);
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(dom, new FileOutputStream(file));
            outBool = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outBool;
    }

    public Element loadFromFile() {
        Document dom = null;
        try {
            SAXBuilder sxb = new SAXBuilder();
            dom = sxb.build(new File(file));
        } catch(Exception e) {
            e.printStackTrace();
        }
        if(dom == null)
            return null;
        else
            return dom.getRootElement();
    }


}
