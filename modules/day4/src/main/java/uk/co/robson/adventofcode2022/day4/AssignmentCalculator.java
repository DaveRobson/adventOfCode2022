package uk.co.robson.adventofcode2022.day4;

public class AssignmentCalculator {

    public Boolean overlap(String pairs) {
        String[] parts = pairs.split(",");
        Assignment a1 = new Assignment(parts[0]);
        Assignment a2 = new Assignment(parts[1]);

        if(a1.difference() > a2.difference()) {
            return a1.getStart() <= a2.getStart() && a1.getEnd() >= a2.getEnd();
        } else {
            return a2.getStart() <= a1.getStart() && a2.getEnd() >= a1.getEnd();
        }
    }

    public Boolean anyOverlap(String pairs) {
        String[] parts = pairs.split(",");
        Assignment a1 = new Assignment(parts[0]);
        Assignment a2 = new Assignment(parts[1]);


        return a1.getStart() <= a2.getEnd() && a1.getEnd() >= a2.getStart() || a2.getStart() <= a1.getEnd() && a2.getEnd() >= a1.getStart();

    }

}
