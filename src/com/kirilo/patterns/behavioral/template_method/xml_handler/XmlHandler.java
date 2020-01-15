package com.kirilo.patterns.behavioral.template_method.xml_handler;

import com.kirilo.patterns.behavioral.template_method.Element;
import com.kirilo.patterns.behavioral.template_method.ElementRepository;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

//https://dzone.com/articles/java-the-factory-pattern
//https://stackoverflow.com/questions/14159086/how-to-get-values-of-all-elements-from-xml-string-in-java
//https://issue.life/questions/48796355
public abstract class XmlHandler implements Handler{
    @Override
    public void parse(String snippet) {
        NodeList nodeList = getNodeList(snippet);
        ElementRepository repository = new ElementRepository(nodeList);
        Element element;
        do {
            element = repository.getNextElement();
        } while (handleElement(element));
    }

    private NodeList getNodeList(String snippet) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource source = new InputSource();
            source.setCharacterStream(new StringReader(snippet));

            Document document = documentBuilder.parse(source);
            return document.getElementsByTagName("*");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
