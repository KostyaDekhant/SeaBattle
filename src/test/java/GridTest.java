import org.junit.Assert;
import org.junit.Ignore;
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

    @Ignore
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

    @Test
    public void generateShipsMethodExistsTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        int[][] field = grid.getGrid();
        int shipCount = 0;
        for (int[] row : field) {
            for (int cell : row) {
                if (cell == 1) shipCount++;
            }
        }
        Assert.assertTrue(shipCount > 0); // хотя бы один корабль
    }

    @Test
    public void doubleDeckShipExistsTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        int[][] field = grid.getGrid();
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (field[i][j] == 1 && field[i][j + 1] == 1) {
                    found = true;
                }
            }
        }
        Assert.assertTrue(found);
    }

    @Test
    public void tripleDeckShipExistsTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        int[][] field = grid.getGrid();
        boolean found = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] == 1 && field[i+1][j] == 1 && field[i+2][j] == 1) {
                    found = true;
                }
            }
        }
        Assert.assertTrue(found);
    }

    @Test
    public void quadrupleDeckShipExistsTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        int[][] field = grid.getGrid();
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (field[i][j] == 1 && field[i][j+1] == 1
                        && field[i][j+2] == 1 && field[i][j+3] == 1) {
                    found = true;
                }
            }
        }
        Assert.assertTrue(found);
    }

    @Test
    public void missShotTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        int cell = grid.shoot(4, 4); // предположим, что там пусто
        Assert.assertEquals(-1,cell); //-1 - промах
    }

    @Test
    public void hitShotTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        int cell = grid.shoot(0, 0);
        Assert.assertEquals(2,cell); //2 - попадание
    }

    @Test
    public void destroyDoubleDeckShipTest() {
        GridClass grid = new GridClass();
        grid.generateShips();
        grid.shoot(2, 2); // первая палуба
        grid.shoot(2, 3); // вторая палуба
        boolean destroyed = grid.isShipDestroyed(2, 2);
        Assert.assertTrue(destroyed);
    }

}
