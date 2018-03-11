package homework3;

public class Board {
    private Cell[][] board = new Cell[8][8];

    private final int[] startRowsWithCheckers = {0, 1, 2, 5, 6, 7};
    private final int[] startRemainders = {1, 0, 1, 0, 1, 0};
    private final boolean[] startColors = {false, false, false, true, true, true};
    private final String lastBoardString = "  a b c d e f g h";
    boolean isWinnerWhite;


    public Board() {
        fillBoard();
    }

    public boolean makeStep(Coordinates oldCoords, Coordinates newCoords, boolean isWhitePlayer) {
        if (!isValidStep(oldCoords, newCoords, isWhitePlayer)) return false;
        int oldX = oldCoords.getCurCoordinates()[0];
        int oldY = oldCoords.getCurCoordinates()[1];

            if (isValidSimpleStepQueen(oldCoords, newCoords, isWhitePlayer) && board[oldX][oldY].getChecker().getIsQueen()) {
                moveChecker(oldCoords, newCoords);
                return true;
            } else if (isValidAttackStepQueen(oldCoords, newCoords, isWhitePlayer) && board[oldX][oldY].getChecker().getIsQueen()) {
                int[] diff = oldCoords.minus(newCoords);
                for (int i = 1; i < Math.abs(diff[0]); i++) {
                    int curX = oldCoords.getCurCoordinates()[0] + (int) Math.signum(diff[0]) * i;
                    int curY = oldCoords.getCurCoordinates()[1] + (int) Math.signum(diff[1]) * i;
                    if (board[curX][curY].getChecker() != null) {
                        board[curX][curY].removeChecker();
                        moveChecker(oldCoords, newCoords);
                        return true;
                    }

                }
            } else if (isValidSimpleStep(oldCoords, newCoords, isWhitePlayer)) {
                    moveChecker(oldCoords, newCoords);
                    return true;
            } else if (isValidAttackStep(oldCoords, newCoords, isWhitePlayer)) {
                int[] diff = oldCoords.minus(newCoords);
                int attackedCheckerX = diff[0] / 2 + oldX;
                int attackedCheckerY = diff[1] / 2 + oldY;
                board[attackedCheckerX][attackedCheckerY].removeChecker();
                moveChecker(oldCoords, newCoords);
                return true;
            }

        return false;
    }

    private boolean isValidStep(Coordinates oldCoords, Coordinates newCoords, boolean isWhitePlayer) {
        int newX = newCoords.getCurCoordinates()[0];
        int newY = newCoords.getCurCoordinates()[1];
        int oldX = oldCoords.getCurCoordinates()[0];
        int oldY = oldCoords.getCurCoordinates()[1];

        if (board[oldX][oldY].isEmpty()){
            System.out.println("Basic cell is empty!");
            return false;
        }
        if (board[oldX][oldY].getChecker().isWhite != isWhitePlayer) {
            System.out.println("Selected checker is not your!");
            return false;
        }
        if (!board[newX][newY].isEmpty()) {
            System.out.println("Target cell is not empty!");
            return false;
        }

        boolean isValidSimple = false;
        boolean isValidAttack = false;

        if (!board[oldX][oldY].getChecker().getIsQueen()) {
            isValidSimple = isValidSimpleStep(oldCoords, newCoords, isWhitePlayer);
        } else if (board[oldX][oldY].getChecker().getIsQueen()) {
            isValidSimple = isValidSimpleStepQueen(oldCoords, newCoords, isWhitePlayer);
        }

        if (!board[oldX][oldY].getChecker().getIsQueen()) {
            isValidAttack = isValidAttackStep(oldCoords, newCoords, isWhitePlayer);
        } else if (board[oldX][oldY].getChecker().getIsQueen()) {
            isValidAttack = isValidAttackStepQueen(oldCoords, newCoords, isWhitePlayer);
        }

        if (isValidSimple || isValidAttack) return true;
        return false;

    }

    private boolean isValidAttackStepQueen(Coordinates oldCoords, Coordinates newCoords, boolean isWhitePlayer) {
        boolean isDiag = false;
        if (Math.abs(oldCoords.minus(newCoords)[0]) == Math.abs(oldCoords.minus(newCoords)[1])) isDiag = true;
        int[] diagLen = oldCoords.minus(newCoords);
        int numChekers = 0;
        for (int i = 1; i < Math.abs(diagLen[0]); i++) {
            int curX = oldCoords.getCurCoordinates()[0] + (int)Math.signum(diagLen[0]) * i;
            int curY = oldCoords.getCurCoordinates()[1] + (int)Math.signum(diagLen[1]) * i;

            if (board[curX][curY].getChecker() != null) {
                if (board[curX][curY].getChecker().isWhite == isWhitePlayer) {
                    System.out.println("Invalid step!");
                    return false;
                }
                if (board[curX][curY].getChecker().isWhite != isWhitePlayer) numChekers++;
            }

        }
        if (numChekers > 1) {
            System.out.println("Invalid step!");
            return false;
        }
        if (numChekers == 0) return false;
        else return true;
    }

    private boolean isValidAttackStep(Coordinates oldCoords, Coordinates newCoords, boolean isWhitePlayer) {
        boolean isDiag = false;
        if ((Math.abs(oldCoords.minus(newCoords)[0]) == 2) && (Math.abs(oldCoords.minus(newCoords)[1]) == 2)) isDiag = true;
        int[] diff = oldCoords.minus(newCoords);
        if (board[diff[0] / 2 + oldCoords.getCurCoordinates()[0]][diff[1] / 2 + oldCoords.getCurCoordinates()[1]].getChecker() == null){
            System.out.println("Invalid target cell coordinates!");
            return false;
        }
        if (isDiag && (isWhitePlayer != board[diff[0] / 2 + oldCoords.getCurCoordinates()[0]][diff[1] / 2 + oldCoords.getCurCoordinates()[1]].getChecker().isWhite)) return true;

        return false;
    }

    private boolean isValidSimpleStepQueen(Coordinates oldCoords, Coordinates newCoords, boolean isWhitePlayer) {
        boolean isDiag = false;
        if (Math.abs(oldCoords.minus(newCoords)[0]) == Math.abs(oldCoords.minus(newCoords)[1])) isDiag = true;

        int[] diagLen = oldCoords.minus(newCoords);
        for (int i = 1; i < Math.abs(diagLen[0]); i++) {
            int curX = oldCoords.getCurCoordinates()[0] + (int)Math.signum(diagLen[0]) * i;
            int curY = oldCoords.getCurCoordinates()[1] + (int)Math.signum(diagLen[1]) * i;

            if (board[curX][curY].getChecker() != null) {
                return false;
            }

        }

        return isDiag;
    }

    private boolean isValidSimpleStep(Coordinates oldCoords, Coordinates newCoords, boolean isWhitePlayer) {
        boolean isDiag = false;
        if ((oldCoords.minus(newCoords)[0] == -1) && (Math.abs(oldCoords.minus(newCoords)[1]) == 1)) isDiag = true;
        if (isWhitePlayer && isDiag) return true;

        if ((oldCoords.minus(newCoords)[0] == 1) && (Math.abs(oldCoords.minus(newCoords)[1]) == 1)) isDiag = true;
        if (!isWhitePlayer && isDiag) return true;

        return false;
    }

    private void moveChecker(Coordinates oldCoords, Coordinates newCoords) {
        int newX = newCoords.getCurCoordinates()[0];
        int newY = newCoords.getCurCoordinates()[1];

        int oldX = oldCoords.getCurCoordinates()[0];
        int oldY = oldCoords.getCurCoordinates()[1];
        if (board[newX][newY].isEmpty()) {
            Checker curChecker = board[oldX][oldY].getChecker();
            board[newX][newY].setChecker(curChecker);
            board[oldX][oldY].removeChecker();
        }
    }

    public void showBoard() {
        StringBuilder visualBoard = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    visualBoard.append(8 - i);
                    visualBoard.append(" ");
                } else {
                    visualBoard.append(board[i][j-1].getSymbol());
                    visualBoard.append(" ");
                }
            }
            visualBoard.append("\n");
        }
        visualBoard.append(lastBoardString);

        System.out.println(visualBoard);
    }

    private void fillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(new Coordinates(i, j));
            }
        }

        for (int i = 0; i < 6; i++) {
            addCheckers(startRowsWithCheckers[i], startRemainders[i], startColors[i]);
        }
    }

    private void addCheckers(int i, int remainder, boolean isWhite) {
        for (int j = 0; j < 8; j++) {
            if (j % 2 == remainder) {
                board[i][j].setChecker(new Checker(i, j, isWhite));
            }
        }
    }

    public boolean isEnd(){
        int numCheckers = 0;
        for (int i = 0; i < 8; i++) {
           for (int j = 0; j <8; j++) {
               if (board[i][j].getChecker() != null) {
                   numCheckers++;
                   isWinnerWhite = board[i][j].getChecker().isWhite;
               }

               if (numCheckers != 1) return false;
           }
        }
        return true;
    }

}
