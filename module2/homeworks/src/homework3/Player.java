package homework3;


public class Player {
    final boolean isWhite;
    private Board board;
    private final String name;

    public Player(boolean isWhite, Board board, String name){
        this.isWhite = isWhite;
        this.board = board;
        this.name = name;
    }

    public boolean step(String arg) {
        String[] cells = arg.split("-");
        Coordinates[] coordinates = new Coordinates[cells.length];
        for (int i = 0; i < cells.length; i++) {
            if (checkCoords(cells[i])) coordinates[i] = parseCoords(cells[i]);
            else return false;
        }
        boolean validStep = false;
        for (int i = 0; i < (coordinates.length - 1); i++) {
            boolean curValidStep = board.makeStep(coordinates[i], coordinates[i+1], isWhite);
            if (!validStep && curValidStep) validStep = true;
            board.showBoard();
        }
        return validStep;
    }

    private boolean checkCoords(String cell) {
        if (cell.length() != 2) {
            System.out.println("Invalid input format!");
            return false;
        }
        int x = (int)cell.charAt(0) - 97;
        if ((x < 0) || (x > 7)) {
            System.out.println("Out of board value!");
            return false;
        }

        int y = Integer.parseInt(new StringBuilder().append("").append(cell.charAt(1)).toString());
        y = Math.abs(8 - y);
        if ((y < 0) || (y > 7)) {
            System.out.println("Out of board value!");
            return false;
        }
        return true;
    }
    private Coordinates parseCoords(String cell) {
        int x = (int)cell.charAt(0) - 97;
        int y = Integer.parseInt(new StringBuilder().append("").append(cell.charAt(1)).toString());
        y = Math.abs(8 - y);
        return new Coordinates(y, x);
    }

    public String getName() { return name; }
}
