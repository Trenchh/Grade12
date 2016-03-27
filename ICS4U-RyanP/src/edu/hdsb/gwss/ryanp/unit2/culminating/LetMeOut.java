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
    private static final boolean FOUND = false;

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
    public boolean findExitFrom(int row, int col) {
        boolean successful = false;

        return successful;
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

    public int up(int row, int col, boolean FOUND) {
        if (Integer.toString(maze[row + 1][col]) == "X") {
            FOUND = true;
            row = row + 1;
            return row & col;
        } else if (Integer.toString(maze[row + 1][col]) == "W" || Integer.toString(maze[row + 1][col]) == "-") {
            return row & col;
        } else {
            maze[row + 1][col] = TRIED;
            row = row + 1;
            return row & col;
        }
    }

    public int down(int row, int col, boolean FOUND) {
        if (Integer.toString(maze[row - 1][col]) == "X") {
            FOUND = true;
            row = row - 1;
            return row & col;
        } else if (Integer.toString(maze[row - 1][col]) == "W" || Integer.toString(maze[row - 1][col]) == "-") {
            return row & col;
        } else {
            maze[row - 1][col] = TRIED;
            row = row - 1;
            return row & col;
        }
    }

    public int right(int row, int col, boolean FOUND) {
        if (Integer.toString(maze[row][col + 1]) == "X") {
            FOUND = true;
            col = col + 1;
            return row & col;
        } else if (Integer.toString(maze[row][col + 1]) == "W" || Integer.toString(maze[row][col + 1]) == "-") {
            return row & col;
        } else {
            maze[row][col + 1] = TRIED;
            col = col + 1;
            return row & col;
        }
    }

    public int left(int row, int col, boolean FOUND) {
        if (Integer.toString(maze[row][col - 1]) == "X") {
            FOUND = true;
            col = col - 1;
            return row & col;
        } else if (Integer.toString(maze[row][col - 1]) == "W" || Integer.toString(maze[row][col - 1]) == "-") {
            return row & col;
        } else {
            maze[row][col - 1] = TRIED;
            col = col - 1;
            return row & col;
        }
    }
}
