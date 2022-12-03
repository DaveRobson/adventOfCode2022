package uk.co.robson.adventofcode2022.day3;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("input.txt");
        parsed.stream()
                .map(Exercise1::splitSearch)
                .map(Exercise1::letterValue)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    public static char splitSearch(String line) {
        char[] chars = line.toCharArray();
        int half = chars.length / 2;

        for(int i = 0; i < half; i++) {
            for(int j = half; j < chars.length; j++) {
                if(chars[i] == chars[j]) {
                    return chars[i];
                }
            }
        }

        return 0;
    }

    public static int letterValue(int letter) {
        return Character.isUpperCase(letter) ? letter - 38 : letter - 96;

    }
}
