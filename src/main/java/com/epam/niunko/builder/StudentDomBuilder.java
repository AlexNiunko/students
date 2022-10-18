package com.epam.niunko.builder;

import com.epam.niunko.entity.Address;
import com.epam.niunko.entity.Student;
import com.epam.niunko.validator.StudentErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudentDomBuilder{

    private Set<Student>students;

    private DocumentBuilder docBuilder;

    public StudentDomBuilder(){
        students= new HashSet<Student>();
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        try{
            docBuilder= factory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            System.err.println("Ошибка конфиурации парсера "+ e);
        }
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void buildSetStudents(String filename) throws IOException, SAXException {
        try{
            Document doc= docBuilder.parse(filename);
            Element root=doc.getDocumentElement();
            NodeList studentList= root.getElementsByTagName("student");
            for (int i = 0; i <studentList.getLength() ; i++) {
                Element studentElement=(Element) studentList.item(i);
                Student student=buildStudent(studentElement);
                students.add(student);
            }
        } catch (IOException  |SAXException e) {
            e.printStackTrace();
        }
    }
    private Student buildStudent(Element studentElement){
        Student student=new Student();
        student.setId(studentElement.getAttribute("id").toLowerCase());
        student.setLogin(studentElement.getAttribute("login").toLowerCase());
        student.setFaculty(studentElement.getElementsByTagName("faculty").item(0).getTextContent());
        student.setName(studentElement.getElementsByTagName("name").item(0).getTextContent());
        student.setTelephone(Integer.parseInt(studentElement.getElementsByTagName("telephone").item(0).getTextContent()));
        Address address= student.getAddress();
        Element addressElement=(Element) studentElement.getElementsByTagName("address").item(0);
        address.setCountry(addressElement.getElementsByTagName("country").item(0).getTextContent());
        address.setCity(addressElement.getElementsByTagName("city").item(0).getTextContent());
        address.setStreet(addressElement.getElementsByTagName("street").item(0).getTextContent());

        return student;
    }
    private static String getElementTextContent(Element element,String elementName){
        NodeList nlist=element.getElementsByTagName(elementName);
        Node node=nlist.item(0);
        String text= node.getTextContent();
        return text;
    }
}
