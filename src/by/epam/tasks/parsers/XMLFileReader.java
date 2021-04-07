package by.epam.tasks.parsers;

import by.epam.tasks.exceptions.XMLFileExceptions;

import java.io.*;

public class XMLFileReader implements Closeable {
    private BufferedReader reader;

    public StringBuffer readFile(String xmlFile) throws XMLFileExceptions{
        StringBuffer fileData = new StringBuffer("");

        try{
            reader = new BufferedReader(new FileReader(xmlFile));
            String line = reader.readLine();

            while (line != null) {
                fileData.append(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e){
            throw new XMLFileExceptions("File not found. Check paths.");
        } catch (IOException e){
            throw new XMLFileExceptions("There is a problem reading the file. Run the program later :)");
        }

        return fileData;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
