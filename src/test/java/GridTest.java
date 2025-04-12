import org.junit.Assert;
import org.junit.Test;

public class GridTest {

    @Test
    public void gridClassCreationTest(){
        GridClass grid = new GridClass();
        Assert.assertNotNull(grid);
    }

    @Test
    public void getGridSizeTest(){
        GridClass grid = new GridClass();
        Assert.assertNotNull(grid.getSize());
    }

    @Test
    public void getRealGridSizeTest(){
        GridClass grid = new GridClass();
        Assert.assertArrayEquals(new int[]{10,10}, grid.getSize());
    }

    @Test
    public void getGrid(){
        GridClass gridClass = new GridClass();
        int [][] grid = gridClass.getGrid();
        Assert.assertNotNull(grid);
    }

    @Test
    public void singleDeckShipExistsTest() {
        GridClass grid = new GridClass();
        int[][] field = grid.getGrid();
        boolean found = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] == 1) {
                    found = true;
                }
            }
        }
        Assert.assertTrue(found);
    }

}
