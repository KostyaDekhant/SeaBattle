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
        grid[2][2] = 1;
        grid[2][3] = 1; // горизонтальный двухпалубник
    }
}
