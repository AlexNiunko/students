package com.epam.niunko.builder;

import com.epam.niunko.builder.StudentEnum;
import com.epam.niunko.entity.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class StudentHandler extends DefaultHandler {

    private Set<Student> students;
    private Student current;
    private StudentEnum currentEnum;
    private EnumSet<StudentEnum> withText;
    private static final String ELEMENT_STUDENT = "student";

    public StudentHandler() {
        students = new HashSet<>();
        withText = EnumSet.range(StudentEnum.NAME, StudentEnum.STREET);
    }

    public Set<Student> getStudents() {
        return students;
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (ELEMENT_STUDENT.equals(qName)) {
            current = new Student();
            current.setLogin(attributes.getValue(0));
            if (attributes.getLength() == 2) {
                current.setFaculty(attributes.getValue(1));
            } else {
                StudentEnum temp = StudentEnum.valueOf(qName.toUpperCase(Locale.ROOT));
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
            }
        }
    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (ELEMENT_STUDENT.equals(qName)) {
            students.add(current);
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        String s=new String(ch,start,length);
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case TELEPHONE:
                    current.setTelephone(Integer.parseInt(s));
                    break;
                case STREET:
                    current.getAddress().setStreet(s);
                    break;
                case CITY:
                    current.getAddress().setCity(s);
                    break;
                case COUNTRY:
                    current.getAddress().setCountry(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
