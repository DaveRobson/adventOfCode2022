package uk.co.robson.adventofcode2022.day4;

public class Assignment {
    private int start;
    private int end;

    public Assignment(String range) {
        String[] parts = range.split("-");
        this.start = Integer.parseInt(parts[0]);
        this.end = Integer.parseInt(parts[1]);
    }

    public Assignment(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public int difference() {
        return end - start;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
