public class GridClass {
    int width = 10;
    int height = 10;

    private int[][] grid = new int[width][height];

    GridClass() {  } //todo перенести метод генерации в конструктор

    public int[] getSize() { return new int[]{width, height}; }

    public int[][] getGrid() { return grid;}

    public void generateShips() {
        //todo сделать генерацию всех кораблей
        grid[0][0] = 1;
        grid[2][2] = 1; grid[2][3] = 1;

        grid[5][5] = 1; grid[6][5] = 1; grid[7][5] = 1;

        grid[8][5] = 1; grid[8][6] = 1; grid[8][7] = 1; grid[8][8] = 1;

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

}
