package uk.co.robson.adventofcode2020.day8;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        int[][] input = parser.parseFile2D("input.txt", 99);
        Forest forest = new Forest(input);
        System.out.println("Visible trees " + forest.walk());
    }
}
