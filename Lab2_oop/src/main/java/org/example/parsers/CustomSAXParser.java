package org.example.parsers;

import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.example.greenhouse.Flower;
import org.example.apply.Path;

public class CustomSAXParser implements Parser {
    @Override
    public List<Flower> parse(String path) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(path, handler);
            return handler.getGreenhouse();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Parser parser = new CustomSAXParser();
        System.out.println(parser.parse(Path.getPath(".", "src", "main","java", "resources", "input.xml")));
    }

}
