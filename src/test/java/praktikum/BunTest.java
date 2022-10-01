package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BunTest {
    Bun bun;

    //константы
    final String BUN = "white bun";
    final int BUN_PRICE = 200;

    @Before
    public void setUp() {
        bun = new Bun(BUN, BUN_PRICE);
    }
    @Test
    public void getNameBunTest() {
        String actual = "white bun";
        String expected = bun.getName();
        Assert.assertEquals("Ожидаемая булка - white bun", expected, actual);
    }
    @Test
    public void getPriceBunTest() {
        float expected = 200L;
        float actual = bun.getPrice();
        Assert.assertEquals("Ожидаемая цена  - 200 " + expected, expected, actual, 0);
    }
}

