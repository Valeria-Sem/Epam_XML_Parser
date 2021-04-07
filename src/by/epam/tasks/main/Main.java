package by.epam.tasks.main;

import by.epam.tasks.elements.Node;
import by.epam.tasks.exceptions.XMLFileExceptions;
import by.epam.tasks.parsers.XMLFileParser;
import by.epam.tasks.parsers.XMLFileReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws XMLFileExceptions{
        XMLFileParser c = new XMLFileParser("resources\\menu.xml");
//        XMLFileReader c = new XMLFileReader();
//
//            c.readFile("resources\\menu.xml");
         c.parse();
    }
}
