package by.epam.tasks.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {
    private String name;
    private List<Attribute> attributes;

    private LinkedList<Node> children;
    private String content;

    public Node() {
    }

    public Node(NodeBuilder builder) {
        this.attributes = builder.attributes;
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public LinkedList<Node> getChildren() {
        return children;
    }

    public void setChildren(Node child) {
        this.children.add(child);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name) && attributes.equals(node.attributes)
                && children.equals(node.children) && content.equals(node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attributes, children, content);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", children=" + children +
                ", content='" + content + '\'' +
                '}';
    }

    public static class NodeBuilder {
        public String name;
        public ArrayList<Attribute> attributes = new ArrayList<>();

        public NodeBuilder(String node) {
            String[] description = node.substring(1, node.length() - 1).split(" ");
            this.name = description[0];
            if (description.length != 1) {
                for (int i = 1; i < description.length - 1; i += 2) {
                    attributes.add(new Attribute(description[i], description[i + 1]));
                }
            }

        }

//        public NodeBuilder(String attributesString) {
//            //String[] description = value.substring(1, value.length() - 1).split("\"| |=", -1);
//            String[] description = attributesString.substring(1, attributesString.length() - 1).split(" ");
//
//            this.name = description[0];
//            if (description.length != 1) {
//                for (int i = 1; i < description.length - 1; i += 1) {
//                    String attribute[] = description[i].split("=");
//                    String key = attribute[0];
//                    String value = attribute[1].replace("\"", "");
//                    System.out.println(description[i]);
//                    attributes.add(new Attribute(key, value));
//                }
//            }
//
//        }


        public Node build(){
            return new Node();
        }

    }
}
