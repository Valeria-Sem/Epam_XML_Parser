package by.epam.tasks.parsers;

import by.epam.tasks.elements.Node;
import by.epam.tasks.exceptions.XMLFileExceptions;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class XMLFileParser {
    private final String openTagRegExp = "<(\\S*?)[^>]*>.*?";
    private final String closeTagRegExp= "</.*?>";

    private String filePath;
    LinkedList<Node> listOfNodes = new LinkedList<>();
    Node node;

    public XMLFileParser() {
    }

    public XMLFileParser(String filePath) {
        this.filePath = filePath;
    }

    public String[] formattingData(StringBuffer fileData) {
        String[] formatData = fileData.toString()
                .replaceAll(">\\s+", ">")
                .replace(">", ">\n")
                .replace("</", "\n</")
                .replaceAll("\n+", "\n")
                .split("\n");

        for (int i = 0; i < formatData.length; ++i) {
            formatData[i] = formatData[i].trim();
        }

        return formatData;
    }

    public LinkedList createNodes(String[] formatData) {

        Pattern patternOpenTag = Pattern.compile(openTagRegExp);
        Pattern patternCloseTag = Pattern.compile(closeTagRegExp);

        for (String formatDatum : formatData) {

            if (patternOpenTag.matcher(formatDatum).matches() && node == null) {
                node = new Node.NodeBuilder(formatDatum).build();
                listOfNodes.addLast(node);

            } else if (listOfNodes.size() >= 1) {
                if (patternOpenTag.matcher(formatDatum).matches()) {

                    Node current = new Node.NodeBuilder(formatDatum).build();
                    listOfNodes.getLast();
                    listOfNodes.addLast(current);

                } else if (patternCloseTag.matcher(formatDatum).matches()) {
                    listOfNodes.removeLast();

                } else {
                    listOfNodes.getLast().setContent(formatDatum);
                    System.out.println(formatDatum);

                }
            }
        }

        return listOfNodes;
    }

    public void printNodes(LinkedList<Node> nodes) {
        for (Node node : nodes) {
            System.out.println(node.toString());
        }
    }

    public LinkedList<Node> parse() throws XMLFileExceptions {
        XMLFileReader reader = new XMLFileReader();
        StringBuffer stringBuffer = reader.readFile(filePath);

        String[] formatData = formattingData(stringBuffer);
        listOfNodes = createNodes(formatData);

        return listOfNodes;
    }

}
