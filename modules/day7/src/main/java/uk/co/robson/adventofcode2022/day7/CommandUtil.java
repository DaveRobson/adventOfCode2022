package uk.co.robson.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.List;

public class CommandUtil {

    public static Node mkdir(String location, Node parent) {
        Node node = new Node();
        node.setLocation(location);
        node.isDirectory();
        node.setParent(parent);
        return node;
    }

    public static Node touch(String location, int size, Node parent) {
        Node node = new Node();
        node.setLocation(location);
        node.setSize(size);
        node.setParent(parent);
        return node;
    }

    public static FileSystem construct(List<String> lines) {
        FileSystem fs = new FileSystem();
        boolean ls = false;
        Node currentNode = fs.root();

        for (String line : lines) {
            if(line.charAt(0) == '$') {
                String[] parts = line.split(" ");
                if(parts[1].equals("ls")) {
                    ls = true;
                } else {
                    ls = false;
                    currentNode = cd(parts, currentNode);
                }
            } else {
                if(ls) {
                    String[] parts = line.split(" ");
                    currentNode.addChild(createNode(parts, currentNode));
                }
            }
        }

        return fs;

    }

    private static Node createNode(String[] parts, Node parent) {
        switch (parts[0]) {
            case "dir":
                return mkdir(parts[1], parent);
            default:
                return touch(parts[1], Integer.parseInt(parts[0]), parent);
        }
    }

    private static Node cd(String[] parts, Node currentNode) {
        String location = parts[2];
        if(location.equals("..")) {
            return currentNode.parent();
        } else if (location.equals("/")) {
            return currentNode;
        } else {
            return currentNode.children().stream()
                    .filter(node -> node.location().equals(location))
                    .findFirst()
                    .get();
        }
    }



}
