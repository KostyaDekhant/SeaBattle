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
}
