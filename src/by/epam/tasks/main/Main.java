package by.epam.tasks.main;

import by.epam.tasks.parsers.XMLFileParser;
import by.epam.tasks.parsers.XMLFileReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        XMLFileParser c = new XMLFileParser("resources\\menu.xml");
       // c.readFile("resources\\menu.xml");
        c.parse();
    }
}
