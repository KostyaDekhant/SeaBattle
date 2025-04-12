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
}
