package homework3;

public class Checker {
    private Coordinates coordinates;
    private boolean isQueen = false;
    final boolean isWhite;

    public Checker(int x, int y, boolean isWhite) {
        coordinates = new Coordinates(x, y);
        this.isWhite = isWhite;
    }

    public void makeStep(Coordinates coordinates) {
        this.coordinates.setCurCoordinates(coordinates.getCurCoordinates()[0], coordinates.getCurCoordinates()[1]);
        if (!isQueen) {
            isQueen = checkIsQueen();
        }
    }

    private boolean checkIsQueen() {
        if ((coordinates.getCurCoordinates()[0] == 0) && isWhite) return true;
        else if ((coordinates.getCurCoordinates()[0] == 7) && !isWhite) return true;
        else return false;
    }

    public boolean getIsQueen() { return isQueen; }
}
