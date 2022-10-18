package com.epam.niunko.main;

import com.epam.niunko.builder.StudentDomBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DomMainStudent {
    public static void main(String[] args) throws IOException, SAXException {
        StudentDomBuilder domBuilder=new StudentDomBuilder();
        domBuilder.buildSetStudents("data\\students.xml");
        System.out.println(domBuilder.getStudents());
    }
}
