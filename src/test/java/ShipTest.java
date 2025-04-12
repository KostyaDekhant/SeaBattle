import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

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

    @Test
    public void thereAreTenShipsOnTheFieldTest() {
        GridClass grid = new GridClass();
        Player player = new Player();
        player.generateShips();

        List<Ship> ships = player.getShips();

        Assert.assertEquals("Должно быть 10 кораблей на поле", 10, ships.size());
    }
}
