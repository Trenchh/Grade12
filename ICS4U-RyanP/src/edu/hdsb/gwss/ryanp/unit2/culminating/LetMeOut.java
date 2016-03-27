/*
 * Name: LetMeOut.java
 * Date: March 23rd, 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description: 
 */
package edu.hdsb.gwss.ryanp.unit2.culminating;

/**
 */
public class LetMeOut {

    private static final char WALL = 'W';
    private static final char EXIT = 'X';
    private static final char OPEN = '.';
    private static final char TRIED = '-';
    private static final char GOOD_PATH = '+';
    private static final boolean SUCCESSFUL = false;

    private char[][] maze = {
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
        {'W', '.', '.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', 'W', '.', 'W', 'W', 'W'},
        {'W', '.', 'W', '.', '.', '.', 'W', 'W', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', '.', 'W', '.', 'W', 'W', '.', 'W', 'W', 'W', 'W'},
        {'W', '.', 'W', 'W', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'X', 'W', 'W', 'W'}
    };

    /**
     * Display the current maze.
     */
    public void findExitFrom(int row, int col) {
        up(row, col, SUCCESSFUL);
        down(row, col, SUCCESSFUL);
        left(row, col, SUCCESSFUL);
        right(row, col, SUCCESSFUL);

    }

    /**
     * Display the current maze.
     */
    public void solve() {

        // FIND RANDOM START LOCATION
        int row;
        int col;
        do {
            row = (int) (Math.random() * maze.length);
            col = (int) (Math.random() * maze[0].length);
        } while (maze[row][col] != OPEN);

        // START!
        System.out.println("START LOCATION: (" + row + "," + col + ")");
        findExitFrom(row, col);

        // SHOW EXIT
        displayMaze();

    }

    /**
     * Display the current maze.
     */
    public void displayMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LetMeOut lmo = new LetMeOut();
        lmo.displayMaze();
        lmo.solve();

    }

    public int up(int row, int col, boolean SUCCESSFUL) {
        if (SUCCESSFUL == false) {
            switch (maze[row + 1][col]) {
                case EXIT:
                    SUCCESSFUL = true;
                    maze[row + 1][col] = GOOD_PATH;
                    break;
                case OPEN:
                    maze[row + 1][col] = TRIED;
                    row = row + 1;
                    break;
            }
        }
        return row & col;
    }

    public int down(int row, int col, boolean SUCCESSFUL) {
        if (SUCCESSFUL == false) {
            switch (maze[row - 1][col]) {
                case EXIT:
                    SUCCESSFUL = true;
                    maze[row - 1][col] = GOOD_PATH;
                    break;
                case OPEN:
                    maze[row - 1][col] = TRIED;
                    row = row - 1;
                    break;
            }
        }
        return row & col;
    }

    public int left(int row, int col, boolean SUCCESSFUL) {
        if (SUCCESSFUL == false) {

            switch (maze[row][col + 1]) {
                case EXIT:
                    SUCCESSFUL = true;
                    maze[row][col + 1] = GOOD_PATH;
                    break;
                case OPEN:
                    maze[row][col + 1] = TRIED;
                    col = col + 1;
                    break;
            }
        }

        return row & col;
    }

    public int right(int row, int col, boolean SUCCESSFUL) {
        if (SUCCESSFUL == false) {
            switch (maze[row][col - 1]) {
                case EXIT:
                    SUCCESSFUL = true;
                    maze[row][col - 1] = GOOD_PATH;
                    break;
                case OPEN:
                    maze[row][col - 1] = TRIED;
                    col = col - 1;
                    break;
            }
        }
        return row & col;
    }
}
