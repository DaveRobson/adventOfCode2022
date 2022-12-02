package uk.co.robson.adventofcode2022.day2;

import uk.co.robson.adventofcode2022.common.BasicFileParser;
import uk.co.robson.adventofcode2022.day2.domain.ShapeAdvanced;

import java.util.List;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("input.txt");

        int total = parsed.stream()
                .map(Exercise2::gameScore)
                .reduce(Integer::sum)
                .get();

        System.out.println(total);

    }

    private static int gameScore(String play) {
        String[] moves = play.split(" ");
        String playerMove = moves[0];
        String outcome = moves[1];

        ShapeAdvanced opponentShape = ShapeAdvanced.valueOfKey(playerMove);

        return ShapeAdvanced.score(opponentShape, outcome);
    }
}
