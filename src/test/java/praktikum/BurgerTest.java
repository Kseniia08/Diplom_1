package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTests {
    Burger burger;

    //Заглушка на ингредиенты
    public Ingredient getMockedIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    //Заглушка на булки
    public Bun getMockedBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    //констранты
    final String SAUCE = "chili sauce";
    final int SAUCE_PRICE = 300;
    final String FILLING = "sausage";
    final int FILLING_PRICE = 200;
    final String BUN = "white bun";
    final int BUN_PRICE = 200;


    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        Bun expected = getMockedBun (BUN, BUN_PRICE);
        burger.setBuns(expected);
        Assert.assertEquals("Ожидаемая булка " + BUN + "за " + BUN_PRICE, expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient expected = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Ожидаемое наполнение " + FILLING + "за " + FILLING_PRICE, expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Бергер без наполнения", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        Ingredient secondIngredient = getMockedIngredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("В бургере " + SAUCE + "за " + SAUCE_PRICE , firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = getMockedBun(BUN, BUN_PRICE);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals("Ожидаемя цена за бургер " + FILLING_PRICE, 600, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = getMockedBun(BUN, BUN_PRICE);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== white bun ====)%n" +
                "= filling sausage =%n" +
                "(==== white bun ====)%n" +
                "%n" +
                "Price: 600,000000%n");
        Assert.assertEquals("Рецепт бургера - " + expected, expected, actual);
    }

}
