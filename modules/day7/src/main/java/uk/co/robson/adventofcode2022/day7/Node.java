package uk.co.robson.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String location;

    private boolean isDirectory;

    private List<Node> children;

    private Node parent;

    private int size;

    public Node() {
        this.children = new ArrayList<>();
    }

    public Node(String location, Boolean isDirectory, List<Node> children) {
        this.location = location;
        this.isDirectory = isDirectory;
        this.children = children;
    }

    public String location() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }

    public List<Node> children() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node parent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
