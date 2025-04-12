import org.junit.Assert;
import org.junit.Test;
public class PlayerTest {
    @Test
    public void playerClassCreationTest(){
        Player player = new Player();
        Assert.assertNotNull(player);
    }
}
