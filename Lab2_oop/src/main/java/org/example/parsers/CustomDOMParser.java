package org.example.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.example.greenhouse.Flower;
import org.example.apply.Path;
import org.example.apply.Tags;


public class CustomDOMParser implements Parser {
    @Override
    public List<Flower> parse(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName(Tags.FLOWER);
            XMLHandler handler= new XMLHandler();

            for(int i=0; i< nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    handler.addDOM(element);
                }
            }

            return handler.getGreenhouse();
        } catch (SAXException | IOException | ParserConfigurationException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Parser parser = new CustomDOMParser();
        System.out.println(parser.parse(Path.getPath(".", "src", "main","java", "resources", "input.xml")));
    }
}
