package uk.co.robson.adventofcode2022.day5;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("input.txt");
        DockSideParser dockSideParser = new DockSideParser(parsed);
        DockSide dockSide = dockSideParser.execute();
        dockSide.executeInstructionsKeepOrder();
        System.out.println(dockSide.topOfStacks());
    }
}