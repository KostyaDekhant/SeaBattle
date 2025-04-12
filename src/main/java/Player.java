import java.util.ArrayList;
import java.util.List;

public class Player {
    private GridClass grid = new GridClass();

    private List<Ship> ships = new ArrayList<>();

    public void generateShips() {
        ships = grid.generateShips();
    }

    public List<Ship> getShips() {
        return ships;
    }
    public GridClass getGrid() {
        return grid;
    }

    public boolean makeMove(int x, int y, Player opponent) {
        return opponent.grid.shoot(x, y) != 1;
    }

    public boolean hasLost() {
        int[][] field = grid.getGrid();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] == 1) return false; // есть ещё живые палубы
            }
        }
        return true;
    }

}