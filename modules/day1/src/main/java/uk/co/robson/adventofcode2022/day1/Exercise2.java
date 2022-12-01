package uk.co.robson.adventofcode2022.day1;

import uk.co.robson.adventofcode2022.common.BasicFileParser;

import java.util.*;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<String> parsed = parser.parseFile("exercise1/input.txt");
        TreeSet<Integer> top3 = new TreeSet<>();

        int subTotal = 0;

        for(String s : parsed) {
            if(s.isEmpty()) {
                if(inTop3(top3, subTotal)) {
                    if(top3.size() == 3) {
                        top3.remove(top3.first());
                    }
                    top3.add(subTotal);
                }

                subTotal = 0;
            } else {
                int cal = Integer.parseInt(s);
                subTotal += cal;
            }
        }

        System.out.println(top3.stream().reduce(Integer::sum));
    }

    private static Boolean inTop3(TreeSet<Integer> top3, int subTotal) {
        return top3.size() < 3 || top3.first() < subTotal && top3.size() == 3;
    }
}
