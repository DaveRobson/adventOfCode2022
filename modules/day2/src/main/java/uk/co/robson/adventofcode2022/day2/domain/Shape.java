package uk.co.robson.adventofcode2022.day2.domain;

import java.util.Arrays;
import java.util.List;

public enum Shape {
    ROCK(1, "A", "X"),
    PAPER(2, "B", "Y"),
    SCISSORS(3, "C", "Z");

    private int score;
    private List<String> keys;

    Shape(int score, String ...keys) {
        this.score = score;
        this.keys = Arrays.asList(keys);

    }

    public int score() {
        return score;
    };

    public List<String> keys() {
        return keys;
    };

    public static Shape valueOfKey(String key) {
        return Arrays.stream(Shape.values())
                .filter(s -> s.keys.contains(key))
                .findFirst()
                .get();
    }

    public static int score(Shape s1, Shape s2) {
        switch(s2) {
            case ROCK:
                if (s1 == SCISSORS) {
                    return s2.score() + 6;
                } else if (s1 == PAPER) {
                    return s2.score();
                } else {
                    return s2.score() + 3;
                }
            case SCISSORS:
                if (s1 == PAPER) {
                    return s2.score() + 6;
                } else if (s1 == ROCK) {
                    return s2.score();
                } else {
                    return s2.score() + 3;
                }
            case PAPER:
                if (s1 == ROCK) {
                    return s2.score() + 6;
                } else if (s1 == SCISSORS) {
                    return s2.score();
                } else {
                    return s2.score() + 3;
                }
            default:
                throw new RuntimeException("unknown type");

        }
    }




}
