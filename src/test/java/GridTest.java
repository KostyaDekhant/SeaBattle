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
}
