public class Player {
    private GridClass grid = new GridClass();

    public GridClass getGrid() {
        return grid;
    }

    public boolean makeMove(int x, int y, Player opponent) {
        return opponent.grid.shoot(x, y) != 1;
    }
}