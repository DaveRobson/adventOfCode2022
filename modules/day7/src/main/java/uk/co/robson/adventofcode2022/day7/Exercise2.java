package uk.co.robson.adventofcode2022.day7;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.Comparator;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        int spaceFree = 23123469;
        int spaceNeeded = 6876531;

        BasicFileParser parser = new BasicFileParser();
        List<String> input = parser.parseFile("input.txt");
        FileSystem fs = CommandUtil.construct(input);
        fs.rawStream()
                .filter(n -> n.size() > spaceNeeded)
                .min(Comparator.comparingInt(Node::size))
                .ifPresent(n -> {
                    System.out.println(n.size());
                });


    }
}
