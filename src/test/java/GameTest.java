import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    @Test
    public void gameInitializationTest() {
        Game game = new Game();
        Assert.assertNotNull(game);
    }
}
