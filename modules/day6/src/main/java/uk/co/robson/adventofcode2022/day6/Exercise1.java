package uk.co.robson.adventofcode2022.day6;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        String input = parser.loadInputData("input.txt");

        int endNumber = 0;
        for(int i = 0; i < input.length(); i++) {

            if(!hasDuplicate(input.substring(i, i + 4))) {
                endNumber = i;
                break;
            }
        }

        System.out.println(endNumber + 4);
    }

    private static Boolean hasDuplicate(String subString) {
        char[] chars = subString.toCharArray();
        Boolean duplicate = false;

        for(int i = 0; i < chars.length; i++) {
            for(int j = i + 1; j < chars.length; j++) {
                if(chars[i] == chars[j]) {
                    duplicate = true;
                }
            }
        }

        return duplicate;
    }

}

