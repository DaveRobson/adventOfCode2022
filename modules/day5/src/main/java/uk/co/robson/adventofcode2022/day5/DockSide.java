package uk.co.robson.adventofcode2022.day5;

import java.util.*;

public class DockSide {

    private Map<Integer, Deque<Character>> stacks;
    private List<CraneInstruction> instructions;

    public DockSide(Map<Integer, Deque<Character>> stacks, List<CraneInstruction> instructions) {
        this.stacks = stacks;
        this.instructions = instructions;
    }

    public void executeInstructions() {
        for(CraneInstruction instruction : instructions) {
            Deque<Character> fromStack = stacks.get(instruction.from());
            Deque<Character> toStack = stacks.get(instruction.to());

            int counter = 0;

            while(counter < instruction.quality()) {
                Character crate = fromStack.pollLast();
                toStack.addLast(crate);
                counter++;
            }
        }
    }

    public void executeInstructionsKeepOrder() {
        for(CraneInstruction instruction : instructions) {
            Deque<Character> fromStack = stacks.get(instruction.from());
            Deque<Character> toStack = stacks.get(instruction.to());

            int counter = 0;
            Deque<Character> lastFirst = new ArrayDeque<>();

            while(counter < instruction.quality()) {
                Character crate = fromStack.pollLast();
                lastFirst.addFirst(crate);
                counter++;
            }

            for(Iterator<Character> iterator = lastFirst.iterator(); iterator.hasNext();) {
                toStack.addLast(iterator.next());
            }
        }
    }

    public String topOfStacks() {
        StringBuilder builder = new StringBuilder();

        for(int key : stacks.keySet()) {
            builder.append(stacks.get(key).peekLast());
        }

        return builder.toString();
    }
}
