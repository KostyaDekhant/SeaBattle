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
}
