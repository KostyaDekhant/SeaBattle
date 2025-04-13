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
        s3.addCell(5, 5); grid[5][5] = 1;
        s3.addCell(6, 5); grid[6][5] = 1;
        s3.addCell(7, 5); grid[7][5] = 1;

        Ship s4 = new Ship();
        s4.addCell(8, 5); grid[8][5] = 1;
        s4.addCell(8, 6); grid[8][6] = 1;
        s4.addCell(8, 7); grid[8][7] = 1;
        s4.addCell(8, 8); grid[8][8] = 1;

        Ship s5 = new Ship(); grid[9][9] = 1;
        Ship s6 = new Ship(); grid[9][7] = 1;
        Ship s7 = new Ship(); grid[9][5] = 1;
        Ship s8 = new Ship(); grid[9][3] = 1;
        Ship s9 = new Ship(); grid[9][1] = 1;
        Ship s10 = new Ship(); grid[9][0] = 1;

        ships.add(s1);
        ships.add(s2);
        ships.add(s3);
        ships.add(s4);
        ships.add(s5);
        ships.add(s6);
        ships.add(s7);
        ships.add(s8);
        ships.add(s9);
        ships.add(s10);

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

    public void printMap() {
        System.out.print("  ");
        for (int j = 1; j <= 10; j++) System.out.print(j + " ");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if('А' + i >= 'Ё') System.out.print((char) ('Б' + i) + " ");
            else System.out.print((char) ('А' + i) + " ");
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 2) {
                    System.out.print("X ");
                } else if (grid[i][j] == -1) {
                    System.out.print("• ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
