package by.epam.tasks.main;

import by.epam.tasks.parsers.XMLFileReader;

public class Main {

    public static void main(String[] args) {
        XMLFileReader c = new XMLFileReader();
        c.readFile("resources\\menu.xml");
    }
}
