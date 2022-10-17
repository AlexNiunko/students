package com.epam.niunko.parser;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SaxParser {
    public static void main(String[] args) {
        try {
            XMLReader reader= XMLReaderFactory.createXMLReader();
            ConsoleStudentHandler handler=new ConsoleStudentHandler();
            reader.setContentHandler(handler);
            reader.parse("data\\students.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
