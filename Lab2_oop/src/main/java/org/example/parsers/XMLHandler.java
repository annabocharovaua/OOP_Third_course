package org.example.parsers;

import org.example.greenhouse.*;
import org.example.apply.Tags;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {
    private List<Flower> greenhouse;
    private String element;

    public XMLHandler() {
        this.greenhouse = new ArrayList<Flower>();
    }

    private Flower getLastFlower() {
        return greenhouse.get(greenhouse.size()-1);
    }

    public void setField(String qName, String value) {
        switch(qName) {
            case Tags.ID ->
                    getLastFlower().setId(Integer.parseInt(value));
            case Tags.NAME ->
                getLastFlower().setName(value);
            case Tags.SOIL ->
                getLastFlower().setSoil(Soil.valueOf(value));
            case Tags.ORIGIN ->
                getLastFlower().setOrigin(value);
            case Tags.STEM_COLOR ->
                getLastFlower().getVisualParameters().setStemColor(value);
            case Tags.LEAVES_COLOR ->
                getLastFlower().getVisualParameters().setLeavesColor(value);
            case Tags.AVERAGE_SIZE ->
                getLastFlower().getVisualParameters().setAverageSize(Float.parseFloat(value));
            case Tags.TEMPERATURE ->
                getLastFlower().getGrowingTips().setTemperature(Integer.parseInt(value));
            case Tags.IS_LIGHTING ->
                getLastFlower().getGrowingTips().setLighting(Boolean.parseBoolean(value));
            case Tags.WATER_AMOUNT ->
                getLastFlower().getGrowingTips().setWaterAmount(Integer.parseInt(value));
            case Tags.MULTIPLYING ->
                getLastFlower().setMultiplying(Multiplying.valueOf(value));

        }
    }
    @Override
    public void startDocument() throws SAXException {
        this.greenhouse = new ArrayList<>();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("Flower")) {
            greenhouse.add(new Flower());
        }

        if(attributes!=null) {
            for( int i=0; i<attributes.getLength(); i++) {
                setField(attributes.getQName(i), attributes.getValue(i));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        element = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        setField(qName, element);
    }

    public List<Flower> getGreenhouse() {
            return new ArrayList<>(greenhouse);
    }

    public void emptyFlower() {
        if(greenhouse == null){
            greenhouse = new ArrayList<Flower>();
        }

        greenhouse.add(new Flower());
    }

    public void addDOM(Element currentElement){
        emptyFlower();
        NamedNodeMap attributes = currentElement.getAttributes();

        setField("name", currentElement.getElementsByTagName("name").item(0).getTextContent());
        setField("soil", currentElement.getElementsByTagName("soil").item(0).getTextContent());
        setField("origin", currentElement.getElementsByTagName("origin").item(0).getTextContent());
        setField("stemColor", currentElement.getElementsByTagName("stemColor").item(0).getTextContent());
        setField("leavesColor", currentElement.getElementsByTagName("leavesColor").item(0).getTextContent());
        setField("averageSize", currentElement.getElementsByTagName("averageSize").item(0).getTextContent());
        setField("temperature", currentElement.getElementsByTagName("temperature").item(0).getTextContent());
        setField("isLighting", currentElement.getElementsByTagName("isLighting").item(0).getTextContent());
        setField("waterAmount", currentElement.getElementsByTagName("waterAmount").item(0).getTextContent());
        setField("multiplying", currentElement.getElementsByTagName("multiplying").item(0).getTextContent());

        for(int i=0; i<attributes.getLength(); i++) {
            Attr attribute = (Attr) attributes.item(i);
            setField(attribute.getName(), attribute.getValue());
        }



    }

}
