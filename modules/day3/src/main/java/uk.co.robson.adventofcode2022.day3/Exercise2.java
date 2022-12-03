package uk.co.robson.adventofcode2022.day3;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.List;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("input.txt");
        System.out.println(splitSearch(parsed));


    }

    public static int splitSearch(List<String> lines) {

        int total = 0;
        for(int i = 0; i < lines.size() / 3; i++) {
            String line1;
            String line2;
            String line3;


            if (i == 0) {
                line1 = lines.get(i);
                line2 = lines.get(i+1);
                line3 = lines.get(i+2);
            } else {
                int j = i * 3;
                line1 = lines.get(j);
                line2 = lines.get(j+1);
                line3 = lines.get(j+2);
            }

            char groupLetter = recursiveLetterSearch(0, (char) 0, line1, line2, line3);
            total += letterValue(groupLetter);
        }

        return total;
    }

    public static char recursiveLetterSearch(int current, char compare, String ...linesOf3) {
        String currentLine = linesOf3[current];
        char[] letters = currentLine.toCharArray();
        char value = 0;

        for(int i = 0; i < letters.length; i++) {
            if(compare == 0) {
                char returned = recursiveLetterSearch(current + 1, letters[i], linesOf3);
                if(returned > 0) {
                    return returned;
                }
            }

            if (letters[i] == compare) {
                if(current < 2) {
                    return recursiveLetterSearch(current + 1, letters[i], linesOf3);
                } else {
                    return letters[i];
                }
            }
        }

        return value;
    }

    public static int letterValue(int letter) {
        return Character.isUpperCase(letter) ? letter - 38 : letter - 96;

    }
}
