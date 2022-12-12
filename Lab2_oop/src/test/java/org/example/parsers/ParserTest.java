package org.example.parsers;

import static org.junit.jupiter.api.Assertions.*;
import org.example.apply.*;
import org.example.greenhouse.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class ParserTest {
    private static final String pathXML = Path.getPath(".", "src", "main","java", "resources", "input.xml");
    private static final String pathXSD = Path.getPath(".", "src", "main","java", "resources", "XSDShema.xsd");
    private static final String pathXSDInvalid = Path.getPath(".", "src", "main","java", "resources", "XSDInvalid.xsd");
    private static final List<Flower> sortedGreenhouseByWater;
    private static final Comparator<Flower> comparator = Comparator.comparingDouble(flower ->flower.getVisualParameters().getAverageSize());

    static {
        sortedGreenhouseByWater = new ArrayList<>();

        sortedGreenhouseByWater.add(new Flower(0, "Tulip", Soil.PODZOLIC, "Netherlands", new VisualParameters("Green", "Violet", 37), new GrowingTips(7, true, 1000), Multiplying.LEAVES));
        sortedGreenhouseByWater.add(new Flower(3, "Peonies", Soil.GROUND, "Europe", new VisualParameters("Green", "Pink", 45), new GrowingTips(18, true, 1750), Multiplying.CUTTING));
        sortedGreenhouseByWater.add(new Flower(1, "Lily", Soil.GROUND, "America", new VisualParameters("Green", "Pink", 52), new GrowingTips(15, false, 2000), Multiplying.SEEDS));
        sortedGreenhouseByWater.add(new Flower(2, "Rose", Soil.SOD_PODZOLIC, "China", new VisualParameters("Green", "White", 70), new GrowingTips(15, true, 1500), Multiplying.LEAVES));

    }

    private static void testParser(Parser parser) {
        List<Flower> greenhouse = parser.parse(pathXML);
        greenhouse.sort(comparator);
        assertEquals(sortedGreenhouseByWater, greenhouse);
    }

    @Test
    void testCustomDOMParser() {
        testParser(new CustomDOMParser());
    }

    @Test
    void testCustomSAXParser() {
        testParser(new CustomSAXParser());
    }

    @Test
    void testCustomStAXParser() {
        testParser(new CustomStAXParser());
    }

    @Test
    void testValidatorXML(){
        XSDValidator validator = new XSDValidator();
        assertTrue(validator.XSDValidate(pathXML, pathXSD));
        assertFalse(validator.XSDValidate(pathXML, pathXSDInvalid));
    }


}