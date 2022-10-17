package com.epam.niunko.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    public static void main(String[] args) {
        String filename="data\\students.xml";
        String schemaname="data\\students.xsd";
        String logname="logs\\log.txt";
        Schema schema=null;
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory=SchemaFactory.newInstance(language);

        try{
            factory.newSchema(new File(schemaname));
            SAXParserFactory spf=SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser= spf.newSAXParser();
            parser.parse(filename,new StudentErrorHandler(logname));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
