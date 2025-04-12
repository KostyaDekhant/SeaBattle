import org.junit.Assert;
import org.junit.Test;

public class ShipTest {
    @Test
    public void createShipAndAddCellsTest() {
        Ship ship = new Ship();
        ship.addCell(2, 2);
        ship.addCell(2, 3);

        Assert.assertEquals(2, ship.getSize());
    }

    @Test
    public void shipIsDestroyedTest() {
        GridClass grid = new GridClass();
        Ship ship = new Ship();
        ship.addCell(2, 2);
        ship.addCell(2, 3);

        grid.getGrid()[2][2] = 2;
        grid.getGrid()[2][3] = 2;

        Assert.assertTrue(ship.isDestroyed(grid));
    }
}
