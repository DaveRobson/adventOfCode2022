package uk.co.robson.adventofcode2022.day4;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.List;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("input.txt");
        parsed.stream()
                .map(Exercise2::splitAndOverlap)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

    }

    public static int splitAndOverlap(String pairs) {
        AssignmentCalculator calculator = new AssignmentCalculator();
        return calculator.anyOverlap(pairs) ? 1 : 0;
    }
}
