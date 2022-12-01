package uk.co.robson.adventofcode2022.day1;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("exercise1/input.txt");

        int max = 0;
        int subTotal = 0;

        for(String s : parsed) {
            if(s.isEmpty()) {
                if(subTotal > max) {
                    max = subTotal;
                }

                subTotal = 0;
            } else {
                int cal = Integer.parseInt(s);
                subTotal += cal;
            }
        }

        System.out.println(max);
    }

}
