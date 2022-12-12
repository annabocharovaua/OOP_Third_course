package org.example.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.Attribute;
import org.example.greenhouse.Flower;
import org.example.apply.Path;
import org.example.apply.Tags;



public class CustomStAXParser implements Parser{
    @Override
    public List<Flower> parse(String path){
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(path));
            XMLHandler handler = new XMLHandler();

            while(reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(!event.isStartElement()){
                    continue;
                }

                StartElement startElement = event.asStartElement();
                String qName = startElement.getName().getLocalPart();
                Iterator<Attribute> attributesIterator = startElement.getAttributes();
                event = reader.nextEvent();

                if(qName.equals(Tags.FLOWER)){
                    handler.emptyFlower();
                } else {
                    String value = event.asCharacters().getData();
                    handler.setField(qName, value);
                }

                while(attributesIterator.hasNext()) {
                    Attribute attribute = attributesIterator.next();
                    handler.setField(attribute.getName().getLocalPart(), attribute.getValue());
                }
            }

            return handler.getGreenhouse();
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Parser parser = new CustomStAXParser();
        System.out.println(parser.parse(Path.getPath(".", "src", "main","java", "resources", "input.xml")));
    }
}
