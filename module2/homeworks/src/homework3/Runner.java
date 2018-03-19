package homework3;
/*
игра Шашки 1-на-1
допустимое любое количество правильных ходов за 1 раз (если нужно "побить" сразу
несколько шашек противника)
формат ввода: a3-b4,
где а3 - ячейка с шашкой которой игрок хочет ходить
    b4 - ячейка куда игрок хочет походить
 */

import java.util.Scanner;

public class Runner {

    private static Scanner scanner;
    private static Board board;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        board = new Board();

        play();
    }

    private static void play() {
        System.out.println("Players, enter your names, please!");
        System.out.print("Player 1 name (white checkers o, white Queens @): ");
        String arg = scanner.nextLine();
        Player player1 = new Player(true, board, arg);
        System.out.print("Player 2 name (black checkers *, black Queens #): ");
        arg = scanner.nextLine();
        Player player2 = new Player(false, board, arg);
        System.out.println("Examples of valid step:\na3-b4\na3-c5-e3\n");
        if (makePlayerStep(player1, player2)) return;

        if (board.isWinnerWhite) System.out.println("Player " + player1.getName() + " win!");
        else if (!board.isWinnerWhite) System.out.println("Player " + player2.getName() + " win!");
    }

    private static boolean makePlayerStep(Player player1, Player player2) {
        String arg;
        int count = 0;
        Player curPlayer = player1;
        board.showBoard();
        while (!board.isEnd()) {
            switch (count % 2) {
                case 0:
                    curPlayer = player1;
                    break;
                case 1:
                    curPlayer = player2;
                    break;
            }
            System.out.print("Player " + curPlayer.getName() + ", your step: ");
            arg = scanner.nextLine();
            if (arg.charAt(0) == 88) {
                System.out.println("Player " + curPlayer.getName() + " surrendered!");
                return true;
            }
             if (curPlayer.step(arg)) count++;
             else System.out.println("Please, make a valid step!");
        }
        return false;
    }
}
