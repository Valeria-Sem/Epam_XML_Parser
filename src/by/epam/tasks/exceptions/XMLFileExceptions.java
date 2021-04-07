package by.epam.tasks.exceptions;

public class XMLFileExceptions extends Exception{
    private static final long serialVersionUID = 1L;

    public XMLFileExceptions(){
        super();
    }

    public XMLFileExceptions(String message){
        super(message);
    }

    public XMLFileExceptions(Exception e){
        super(e);
    }

    public XMLFileExceptions(String message, Exception e){
        super(message, e);
    }
}
