package homework3;

public class Cell {
    private final Coordinates cellCoords;
    private Checker curChecker = null;
    private char symbol = '-';

    public Cell(Coordinates coordinates) {
        cellCoords = coordinates;
    }


    public void setChecker (Checker checker) {
        curChecker = checker;
        curChecker.makeStep(cellCoords);
        if (checker.isWhite && !checker.getIsQueen()) symbol = 'o';
        else if (checker.isWhite && checker.getIsQueen()) symbol = '@';
        else if (!checker.isWhite && !checker.getIsQueen()) symbol = '*';
        else if (!checker.isWhite && checker.getIsQueen()) symbol = '#';
    }

    public void removeChecker() {
        curChecker = null;
        symbol = '-';
    }

    public Checker getChecker() {
        return curChecker;
    }

    public boolean isEmpty() {
        if (curChecker == null) return true;
        else return false;
    }

    public char getSymbol() { return symbol; }
}
