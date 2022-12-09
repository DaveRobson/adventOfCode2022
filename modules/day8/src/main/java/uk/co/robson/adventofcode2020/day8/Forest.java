package uk.co.robson.adventofcode2020.day8;

public class Forest {

    int[][] grid;

    public Forest(int[][] grid) {
        this.grid = grid;
    }


    public int walk() {
        int width = grid[0].length;
        int height = grid.length;

        int top = 0;
        int left = 0;
        int right = grid[0].length;
        int bottom = grid.length;

        int x = top;
        int y = left;

        int sum = 0;

        for(int i = 0; i < height * width; i++) {
            if(x == (width / 2) && y == (height / 2)) {
                if (isVisible(x, y)) {
                    sum += 1;
                    System.out.println(grid[y][x]);
                }
                break;
            }

            if(x < right && y == top) {
                if (isVisible(x, y)) {
                    sum += 1;
                    System.out.println(grid[y][x]);
                }

                x++;
            }

            if(x == right - 1 && y < bottom-1) {
                if (isVisible(x, y)) {
                    sum += 1;
                    System.out.println(grid[y][x]);
                }
                y++;
            }

            if(y == bottom - 1 && x > left) {
                if (isVisible(x, y)) {
                    sum += 1;
                    System.out.println(grid[y][x]);
                }
                x--;
            }

            if(x == left && y > top) {
                if (isVisible(x, y)) {
                    sum += 1;
                    System.out.println(grid[y][x]);
                }
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

        return sum;
    }

    private Boolean isVisible(int x, int y) {
        int top = 0;
        int left = 0;
        int right = grid[0].length;
        int bottom = grid.length;
        int currentTree = grid[y][x];

        if(x + 1 > right || x - 1 < left || y + 1 > bottom || y - 1 < top) {
            return true;
        }

        boolean leftVisible = true;
        boolean rightVisible = true;
        boolean topVisible = true;
        boolean bottomVisible = true;

        for(int i = x-1; i > -1; i--) {
            int treeLeft = grid[y][i];
            if(currentTree <= treeLeft) {
                leftVisible = false;
                break;
            }
        }

        for(int i = x+1; i < right; i++) {
            int treeRight = grid[y][i];
            if(currentTree <= treeRight) {
                rightVisible =  false;
                break;
            }
        }

        for(int i = y+1; i < bottom; i++) {
            int treeDown = grid[i][x];
            if(currentTree <= treeDown) {
                bottomVisible = false;
                break;
            }
        }

        for(int i = y - 1; i > -1; i--) {
            int treeUp = grid[i][x];
            if(currentTree <= treeUp) {
                topVisible = false;
                break;
            }
        }

        return leftVisible || rightVisible || topVisible || bottomVisible;
    }


    private int scenicScore(int x, int y) {
        int top = 0;
        int left = 0;
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

        return leftScore + rightScore + upScore + downScore;
    }

}
