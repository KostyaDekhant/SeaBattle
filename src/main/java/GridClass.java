import java.util.ArrayList;
import java.util.List;

public class GridClass {
    int width = 10;
    int height = 10;

    private int[][] grid = new int[width][height];

    GridClass() {  } //todo перенести метод генерации в конструктор

    public int[] getSize() { return new int[]{width, height}; }

    public int[][] getGrid() { return grid;}

    public List<Ship> generateShips() {
        //todo сделать генерацию всех кораблей
        List<Ship> ships = new ArrayList<>();

        Ship s1 = new Ship();
        s1.addCell(0, 0); grid[0][0] = 1;

        Ship s2 = new Ship();
        s2.addCell(2, 2); grid[2][2] = 1;
        s2.addCell(2, 3); grid[2][3] = 1;

        Ship s3 = new Ship();
        s3.addCell(2, 2); grid[5][5] = 1;
        s3.addCell(2, 3); grid[6][5] = 1;
        s3.addCell(2, 3); grid[7][5] = 1;

        Ship s4 = new Ship();
        s4.addCell(2, 2); grid[8][5] = 1;
        s4.addCell(2, 3); grid[8][6] = 1;
        s4.addCell(2, 3); grid[8][7] = 1;
        s4.addCell(2, 3); grid[8][8] = 1;

        ships.add(s1);
        ships.add(s2);
        ships.add(s3);
        ships.add(s4);

        return ships;
    }

    public int shoot(int x, int y) {
        if (grid[x][y] == 1) {
            grid[x][y] = 2; // попадание
            return 2;
        } else {
            grid[x][y] = -1; // промах
            return -1;
        }
    }

    public boolean isShipDestroyed(int x, int y) {
        if ((x == 2 && y == 2) || (x == 2 && y == 3)) {
            return grid[2][2] == 2 && grid[2][3] == 2;
        }
        return false;
    }
}
