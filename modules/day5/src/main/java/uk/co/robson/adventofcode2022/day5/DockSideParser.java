package uk.co.robson.adventofcode2022.day5;

import java.util.*;

public class DockSideParser {

    private List<String> inputData;
    private Map<Integer, Deque<Character>> stacks = new HashMap<>();
    private List<CraneInstruction> instructions = new ArrayList<>();

    public DockSideParser(List<String> inputData) {
        this.inputData = inputData;
    }

    public DockSide execute() {
        parseData(inputData);
        return new DockSide(stacks, instructions);
    }


    private void parseData(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            parseLine(lines.get(i));
        }
    }

    private void parseStackLine(String line) {
        double lineLength = line.length();
        Double stacksForLine = Math.ceil(lineLength / 4.0);

        for(int i = 0; i < stacksForLine; i++) {
            int position = i == 0 ? i : i * 4;

            if(line.charAt(position) == '[') {
                char crate = line.charAt(position + 1);
                if(stacks.containsKey(i + 1)) {
                    stacks.get(i + 1)
                            .push(crate);
                } else {
                    Deque<Character> stack = new ArrayDeque<>();
                    stack.push(crate);
                    stacks.put(i + 1, stack);
                }
            }
        }
    }

    private void parseLine(String line) {
        if(!line.isEmpty() && line.charAt(0) == 'm') {
            parseMoveLine(line);
        } else {
            parseStackLine(line);
        }
    }

    private void parseMoveLine(String line) {
        String[] parts = line.split(" ");
        int quality = Integer.parseInt(parts[1]);
        int from = Integer.parseInt(parts[3]);
        int to = Integer.parseInt(parts[5]);

        instructions.add(new CraneInstruction(quality, from, to));
    }
}
