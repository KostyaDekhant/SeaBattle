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
    public void shipTest(){
        GridClass gridClass = new GridClass();
        int [][] grid = gridClass.getGrid();
        boolean isShipCreated = grid[0][0] == 1;
        Assert.assertTrue(isShipCreated);
    }
}
