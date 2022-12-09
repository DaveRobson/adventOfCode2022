package uk.co.robson.adventofcode2022.day7;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> input = parser.parseFile("input.txt");
        FileSystem fs = CommandUtil.construct(input);
        List<Node> totals = fs.dirLessThan(100000);
        totals.stream()
                .map(Node::size)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
