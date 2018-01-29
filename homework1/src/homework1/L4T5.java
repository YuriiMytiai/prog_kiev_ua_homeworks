package homework1;

import java.util.Arrays;
import java.util.Scanner;

public class L4T5 {

    private char[][] grid = new char[3][3];
    private Scanner sc;

    public static void main(String[] args) {
        L4T5 newGame = new L4T5();
        newGame.start();
    }

    public L4T5() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                grid[i][j] = '_';
            }
        }
    }

    public void start() {
        System.out.println("Hello! Let's start!");

        sc = new Scanner(System.in);

        int i = 1;
        char curChar;
        char stepResult;
        boolean continueGame = true;

        while(continueGame) {
            if(i % 2 == 0){
                curChar = 'o';
            } else {
                curChar = 'x';
            }

            showGrid();
            makeStep(curChar);
            stepResult = chekBoard();
            continueGame = checkStep(stepResult);

            i++;
        }

    }



    private void makeStep(char playerChar) {
        System.out.print("Enter indexes through a space delimiter (from 0 to 2):");
        int zeroDimIdx = Integer.parseInt(sc.next());
        int firstDimIdx = Integer.parseInt(sc.next());
        grid[zeroDimIdx][firstDimIdx] = playerChar;
    }

    private char chekBoard() {
        // horizontal checking
        for(int i = 0; i < 3; i++) {
            if((grid[i][0] != '_') && (grid[i][0] == grid[i][1]) && (grid[i][0] == grid[i][2])) {
                return grid[i][0];
            }
        }

        // vertical checking
        for(int i = 0; i < 3; i++) {
            if((grid[0][i] != '_') && (grid[0][i] == grid[1][i]) && (grid[0][i] == grid[2][i])) {
                return grid[0][i];
            }
        }

        // diagonal checking
        if((grid[1][1] != '_') && ((grid[0][0] == grid[1][1]) && (grid[0][0] == grid[2][2]) ||
                ((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0]))) ) {
            return grid[1][1];
        }

        // draw checking
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != '_'){count++;}
            }
        }
        if(count == 9) {
            return Character.MAX_VALUE;
        }

        return Character.MIN_VALUE;
    }

    private void showGrid() {
        for(int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private boolean checkStep(char stepResult) {
        if(stepResult == 'x') {
            System.out.println("Congratulations! First player win!");
            showGrid();
        } else if(stepResult == 'o') {
            System.out.println("Congratulations! Second player win!");
            showGrid();
        } else if(stepResult == Character.MAX_VALUE) {
            System.out.println("That was really hard game... Draw!");
            return false;
        } else if(stepResult == Character.MIN_VALUE) {
            return true;
        }
        return false;
    }
}
