import org.junit.Assert;
import org.junit.Test;
public class PlayerTest {
    @Test
    public void playerClassCreationTest(){
        Player player = new Player();
        Assert.assertNotNull(player);
    }

    @Test
    public void playerCanMakeMoveTest() {
        Player player1 = new Player();
        Player player2 = new Player();
        player2.getGrid().generateShips();

        boolean result = player1.makeMove(0, 0, player2);
        Assert.assertTrue(result); // знаем, что на (0,0) есть корабль
    }

    @Test
    public void playerLosesAfterAllShipsDestroyed() {
        Player player = new Player();
        player.getGrid().generateShips();

        // Уничтожаем все корабли
        player.getGrid().shoot(0, 0);
        player.getGrid().shoot(2, 2); player.getGrid().shoot(2, 3);

        player.getGrid().shoot(5, 5); player.getGrid().shoot(6, 5);
        player.getGrid().shoot(7, 5);

        player.getGrid().shoot(8, 8); player.getGrid().shoot(8, 7);
        player.getGrid().shoot(8, 6); player.getGrid().shoot(8, 5);

        Assert.assertTrue(player.hasLost());
    }
}
