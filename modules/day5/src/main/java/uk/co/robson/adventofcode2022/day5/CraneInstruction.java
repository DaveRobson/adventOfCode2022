package uk.co.robson.adventofcode2022.day5;

public class CraneInstruction {

    private int quality;

    private int from;

    private int to;

    public CraneInstruction(int quality, int from, int to) {
        this.quality = quality;
        this.from = from;
        this.to = to;
    }

    public int quality() {
        return quality;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }
}
