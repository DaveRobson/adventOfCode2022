package uk.co.robson.adventofcode2022.day2;

import uk.co.robson.adventofcode2022.common.BasicFileParser;
import uk.co.robson.adventofcode2022.day2.domain.Shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("input.txt");

        int total = parsed.stream()
                .map(Exercise1::gameScore)
                .reduce(Integer::sum)
                .get();

        System.out.println(total);

    }
    private static int gameScore(String play) {
        String[] moves = play.split(" ");
        String opponent = moves[0];
        String player = moves[1];

        Shape opponentShape = Shape.valueOfKey(opponent);
        Shape playerScore = Shape.valueOfKey(player);

        return Shape.score(opponentShape, playerScore);
    }
}
