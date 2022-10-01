package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    final String SAUCE = "sour cream";
    final int SAUCE_PRICE = 200;



    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE);

    @Test
    public void getPriceTest() {
        float expected = SAUCE_PRICE;
        float actual = ingredient.getPrice();
        assertEquals("Цена не совпадает",expected, actual, 0.00f);
    }

    @Test
    public void getNameTest() {
        String expected = SAUCE;
        String actual = ingredient.getName();
        assertEquals("Название не совпадает", expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals("Тип ингридиента не совпадает", expected, actual);
    }
}
