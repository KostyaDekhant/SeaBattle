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

    @Test
    public void shipsDoNotTouchEachOtherTest() {
        Player player = new Player();
        player.generateShips();
        List<Ship> ships = player.getShips();

        for (int i = 0; i < ships.size(); i++) {
            for (int j = i + 1; j < ships.size(); j++) {
                List<int[]> shipA = ships.get(i).getCells();
                List<int[]> shipB = ships.get(j).getCells();

                for (int[] a : shipA) {
                    for (int[] b : shipB) {
                        if (areTouching(a, b)) {
                            Assert.fail("Корабли соприкасаются: (" + a[0] + " , " + a[1] + ") и (" + b[0] + " , " + b[1] + ")");
                        }
                    }
                }
            }
        }
    }

    private boolean areTouching(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) <= 1 && Math.abs(a[1] - b[1]) <= 1;
    }
}
