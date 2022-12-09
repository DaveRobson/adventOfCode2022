package uk.co.robson.adventofcode2020.day8;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.Comparator;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        int[][] input = parser.parseFile2D("input.txt", 99);
        Forest2 forest = new Forest2(input);
        forest.walk().stream()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);
    }
}
