package com.epam.niunko.builder;

import com.epam.niunko.entity.Student;
import com.epam.niunko.validator.StudentErrorHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class StudentsSaxBuilder   {
    static final Logger logger = LogManager.getLogger();
    private Set<Student> students;
    private StudentHandler sh=new StudentHandler();
    private XMLReader reader;

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public StudentsSaxBuilder(Set<Student> students) {
        this.students = students;
    }

    public StudentsSaxBuilder() throws IOException {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser= factory.newSAXParser();
            reader= saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            logger.log(Level.ERROR, "SAX parser error");
        }
        reader.setErrorHandler(new StudentErrorHandler());
        reader.setContentHandler(sh);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void buildSetStudent(String fileName) {
        try {
            reader.parse(fileName);
            students= sh.getStudents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}
