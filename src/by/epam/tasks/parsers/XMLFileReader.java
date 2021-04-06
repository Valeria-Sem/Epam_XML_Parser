package by.epam.tasks.parsers;

import java.io.*;

public class XMLFileReader implements Closeable {
    private BufferedReader reader;

    public void readFile(String xmlFile){
        try{
            reader = new BufferedReader(new FileReader(xmlFile));
        } catch (FileNotFoundException e){
            System.out.println("File not found. Check paths.");
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
