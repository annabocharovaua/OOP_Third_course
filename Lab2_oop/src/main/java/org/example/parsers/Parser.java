package org.example.parsers;

import org.example.greenhouse.Flower;
import java.util.List;

public interface Parser {
    List<Flower> parse(String pathToXML);
}
