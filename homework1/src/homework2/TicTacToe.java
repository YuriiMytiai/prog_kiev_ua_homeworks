package homework2;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] c = new char[3][3];
    static char[] chars = {'X', '0'};
    static int n = 0; // 0 - 'X', 1 - '0'
    static Random rnd = new Random();

    static void view(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean check() {
        // horizontal check
        for(int i = 0; i < 3; i++) {
            if ((c[i][0] != '?') && (c[i][0] == c[i][1]) && (c[i][0] == c[i][2])) {
                System.out.println("Ура");
                return true;
            }
        }

        // vertical check
        for(int i = 0; i < 3; i++) {
            if((c[0][i] != '?') && (c[0][i] == c[1][i]) && (c[0][i] == c[2][i])) {
                System.out.println("Ура");
                return true;
            }
        }

        // diagonal check
        if((c[1][1] != '?') && ((c[0][0] == c[1][1]) && (c[0][0] == c[2][2]) ||
                ((c[0][2] == c[1][1]) && (c[0][2] == c[2][0]))) ) {
            System.out.println("Ура");
            return true;
        }

        // draw check
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (c[i][j] != '?') count++;
            }
        }
        if (count == 9) {
            System.out.println("Ничья!");
            return true;
        }

        return false;

    }

    static void play(Scanner sc) {

        int i1, i2;
        if (chars[n] == 'X'){
            do {
                System.out.println("User's step:");
                System.out.print("Index 1? (" + chars[n] + "): ");
                i1 = sc.nextInt();
                System.out.print("Index 2? (" + chars[n] + "): ");
                i2 = sc.nextInt();
            } while (c[i1][i2] != '?');
        } else {
            /*
            do {
                i1 = rnd.nextInt(3);
                i2 = rnd.nextInt(3);
            } while (c[i1][i2] != '?');
            */
            System.out.println("Computer's step:");
            int[] idxs = makeStep();
            i1 = idxs[0];
            i2 = idxs[1];
        }

        c[i1][i2] = chars[n];
        n = (n + 1) % 2;
    }

    static void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = '?';
            }
        }
    }

    private static int[] makeStep() {
        int[] pos1 = new int[2];
        int[] pos2 = new int[2];
        int[] pos3 = new int[2];

        // horizontal check
        for(int i = 0; i < 3; i++) {
            pos1[0] = i;
            pos1[1] = 0;

            pos2[0] = i;
            pos2[1] = 1;

            pos3[0] = i;
            pos3[1] = 2;

            int[] idxs = oneEmpty(pos1, pos2, pos3);
            if (idxs[0] != -1) return idxs;
        }

        // vertical check
        for(int i = 0; i < 3; i++) {
            pos1[0] = 0;
            pos1[1] = i;

            pos2[0] = 1;
            pos2[1] = i;

            pos3[0] = 2;
            pos3[1] = i;

            int[] idxs = oneEmpty(pos1, pos2, pos3);
            if (idxs[0] != -1) return idxs;
        }

        // diagonal check
        pos1[0] = 0;
        pos1[1] = 0;

        pos2[0] = 1;
        pos2[1] = 1;

        pos3[0] = 2;
        pos3[1] = 2;

        int[] idxs = oneEmpty(pos1, pos2, pos3);
        if (idxs[0] != -1) return idxs;

        pos1[0] = 2;
        pos1[1] = 0;

        pos2[0] = 1;
        pos2[1] = 1;

        pos3[0] = 0;
        pos3[1] = 2;

        idxs = oneEmpty(pos1, pos2, pos3);
        if (idxs[0] != -1) return idxs;

        // there are 4 possible combinations with 1,1 cell, so computer should try to use it
        if (c[1][1] == '?') return new int[] {1, 1};
        // if no matches
        do {
            idxs[0] = rnd.nextInt(3);
            idxs[1] = rnd.nextInt(3);
        } while (c[idxs[0]][idxs[1]] != '?');

        return idxs;
    }

    // this method returns index of cell in row/col/diag if other 2 cells aren't empty
    private static int[] oneEmpty (int[] pos1, int[] pos2, int[] pos3) {
        if ((c[pos1[0]][pos1[1]] == c[pos2[0]][pos2[1]]) && ((c[pos1[0]][pos1[1]] != '?') && (c[pos3[0]][pos3[1]] == '?'))) return pos3;
        else if ((c[pos1[0]][pos1[1]] == c[pos3[0]][pos3[1]]) && ((c[pos1[0]][pos1[1]] != '?') && (c[pos2[0]][pos2[1]] == '?'))) return pos2;
        else if ((c[pos2[0]][pos2[1]] == c[pos3[0]][pos3[1]]) && ((c[pos2[0]][pos2[1]] != '?') && (c[pos1[0]][pos1[1]] == '?'))) return pos1;
        else return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        clear();
        do {
            play(sc);
            view();
        } while ( ! check());
    }
}
