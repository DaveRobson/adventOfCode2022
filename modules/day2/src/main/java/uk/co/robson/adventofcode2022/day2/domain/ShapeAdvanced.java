package uk.co.robson.adventofcode2022.day2.domain;

import java.util.Arrays;

public enum ShapeAdvanced {

    ROCK(1, "A", 2, 3),
    PAPER(2, "B", 3, 1),
    SCISSORS(3, "C", 1, 2);

    private int score;
    private String key;
    private int lose;

    private int beat;

    ShapeAdvanced(int score, String key, int lose, int beat) {
        this.score = score;
        this.key = key;
        this.lose = lose;
        this.beat = beat;

    }

    public int score() {
        return score;
    };

    public String key() {
        return key;
    };

    public int lose() {
        return lose;
    };

    public int beat() {
        return beat;
    };

    public static ShapeAdvanced valueOfKey(String key) {
        return Arrays.stream(ShapeAdvanced.values())
                .filter(s -> s.key().equals(key))
                .findFirst()
                .get();
    }

    public static int score(ShapeAdvanced s1, String outcome) {
        if (outcome.equals("Z")) {
            return s1.lose() + 6;
        } else if (outcome.equals("X")) {
            return s1.beat();
        } else {
            return s1.score() + 3;
        }
    }
}
