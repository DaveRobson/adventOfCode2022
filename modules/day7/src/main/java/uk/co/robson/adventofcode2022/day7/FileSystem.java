package uk.co.robson.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSystem {

    private Node root;

    public FileSystem() {
        Node root = new Node();
        root.setLocation("/");
        root.setDirectory(Boolean.TRUE);
        this.root = root;
    }

    public FileSystem(Node root) {
        this.root = root;
    }

    public Node root() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public List<Node> dirLessThan(int size) {
        List<Node> totals = new ArrayList<>();

        recursiveTotal(root, totals);
        return totals.stream()
                .filter(n -> n.size() < size)
                .collect(Collectors.toList());
    }

    public Stream<Node> rawStream() {
        List<Node> totals = new ArrayList<>();

        recursiveTotal(root, totals);
        return totals.stream();
    }

    private int recursiveTotal(Node node, List<Node> totals) {
        if(node.children() != null && !node.children().isEmpty()) {
            int size = 0;
            for (Node child : node.children()) {
                size += recursiveTotal(child, totals);
            }

            node.setSize(size);
            totals.add(node);
            return size;

        } else {
            return node.size();
        }
    }
}
