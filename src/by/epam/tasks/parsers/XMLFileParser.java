package by.epam.tasks.parsers;

import by.epam.tasks.elements.Node;

public class XMLFileParser {
    private String openTagRegExp = "<(\\S*?)[^>]*>.*?";
    private String closeTagRegExp= "</.*?>";

//    String oTag = "<([^...&&[^ < / ] ] ) * >"; //Открывающий тег
//    String cTag = "< / >"; // закрывающий тег

    public Node parseXMLFile(){
        return null;
    }

}
