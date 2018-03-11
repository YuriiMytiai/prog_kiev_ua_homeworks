package homework3;

public class Coordinates {
    private int curX;
    private int curY;

    public Coordinates(int x, int y) {
        curX = x;
        curY = y;
    }

    public void setCurCoordinates (int x, int y) {
        curX = x;
        curY = y;
    }

    public int[] getCurCoordinates() {
        return new int[] {curX, curY};
    }


    public int[] minus(Coordinates otherCoords) {
        int[] result = new int[2];
        result[0] = otherCoords.getCurCoordinates()[0] - curX;
        result[1] = otherCoords.getCurCoordinates()[1] - curY;
        return result;
    }

}
