import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridClass {
    int width = 10;
    int height = 10;

    private int[][] grid = new int[width][height];

    GridClass() {  } //todo перенести метод генерации в конструктор

    public int[] getSize() { return new int[]{width, height}; }

    public int[][] getGrid() { return grid;}

    public List<Ship> generateShips() {
        List<Ship> ships = new ArrayList<>();
        int[] shipSizes = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        Random rand = new Random();

        for (int size : shipSizes) {
            boolean placed = false;

            while (!placed) {
                boolean horizontal = rand.nextBoolean();
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);

                List<int[]> positions = new ArrayList<>();
                boolean fits = true;

                for (int i = 0; i < size; i++) {
                    int nx = x + (horizontal ? 0 : i);
                    int ny = y + (horizontal ? i : 0);

                    if (nx >= 10 || ny >= 10 || !isAreaClear(nx, ny)) {
                        fits = false;
                        break;
                    }
                    positions.add(new int[]{nx, ny});
                }
                if (fits) {
                    Ship ship = new Ship();
                    for (int[] pos : positions) {
                        ship.addCell(pos[0], pos[1]);
                        grid[pos[0]][pos[1]] = 1;
                    }
                    ships.add(ship);
                    placed = true;
                }
            }
        }

        return ships;
    }

    private boolean isAreaClear(int x, int y) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10) {
                    if (grid[nx][ny] == 1) return false;
                }
            }
        }
        return true;
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
