package com.epam.niunko.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomeParsing {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= factory.newDocumentBuilder();
        Document document=builder.parse(new File("data\\students.xml"));

        Element element= document.getDocumentElement();
        System.out.println(element.getTagName());
        printElement(element.getChildNodes());


    }
    static void printElement(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            if(nodeList.item(i) instanceof  Element){
                System.out.println(((Element) nodeList.item(i)).getTagName());
                if (nodeList.item(i).hasChildNodes()){
                    printElement(nodeList.item(i).getChildNodes());
                }
            }
        }
    }
}
