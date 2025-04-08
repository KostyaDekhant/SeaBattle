public class GridClass {
    int width = 10;
    int height = 10;

    GridClass() {}

    public int[] getSize() { return new int[]{width, height}; }

    public int[][] getGrid() {
        //todo добавить переменную grid и возвращать уже её
        return new int[][]{{width, height}};
    }
}
