public class GridClass {
    int width = 10;
    int height = 10;

    private int[][] grid = new int[width][height];

    GridClass() { grid[0][0] = 1; }//todo сделать метод для генерации кораблей

    public int[] getSize() { return new int[]{width, height}; }

    public int[][] getGrid() { return grid;}
}
