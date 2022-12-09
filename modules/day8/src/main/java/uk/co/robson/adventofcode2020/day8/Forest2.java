package uk.co.robson.adventofcode2020.day8;

import java.util.ArrayList;
import java.util.List;

public class Forest2 {

    int[][] grid;

    public Forest2(int[][] grid) {
        this.grid = grid;
    }


    public List<Integer> walk() {
        int width = grid[0].length;
        int height = grid.length;

        int top = 0;
        int left = 0;
        int right = grid[0].length;
        int bottom = grid.length;

        int x = top;
        int y = left;

        List<Integer> scores = new ArrayList<>();

        for(int i = 0; i < height * width; i++) {
            if(x == (width / 2) && y == (height / 2)) {
                scores.add(scenicScore(x, y));
                break;
            }

            if(x < right && y == top) {
                scores.add(scenicScore(x, y));
                x++;
            }

            if(x == right - 1 && y < bottom-1) {
                scores.add(scenicScore(x, y));
                y++;
            }

            if(y == bottom - 1 && x > left) {
                scores.add(scenicScore(x, y));
                x--;
            }

            if(x == left && y > top) {
                scores.add(scenicScore(x, y));
                y--;
            }

            if(x == left && y == top) {
                top++;
                left++;
                right--;
                bottom--;
                x = left;
                y = top;
            }
        }

        return scores;
    }

    private int scenicScore(int x, int y) {
        int right = grid[0].length;
        int bottom = grid.length;
        int currentTree = grid[y][x];

        int leftScore = 0;
        int rightScore = 0;
        int upScore = 0;
        int downScore = 0;

        for(int i = x-1; i > -1; i--) {
            int treeLeft = grid[y][i];
            leftScore += 1;

            if(currentTree <= treeLeft) {
                break;
            }

        }

        for(int i = x+1; i < right; i++) {
            int treeRight = grid[y][i];
            rightScore += 1;

            if(currentTree <= treeRight) {
                break;
            }
        }

        for(int i = y+1; i < bottom; i++) {
            int treeDown = grid[i][x];
            downScore += 1;
            if(currentTree <= treeDown) {
                break;
            }
        }

        for(int i = y - 1; i > -1; i--) {
            int treeUp = grid[i][x];
            upScore += 1;
            if(currentTree <= treeUp) {
                break;
            }
        }

        return leftScore * rightScore * upScore * downScore;
    }

}
