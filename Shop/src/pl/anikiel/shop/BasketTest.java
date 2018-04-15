package pl.anikiel.shop;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {

	private static final double PRICE_DELTA = 0.001;

	private Basket basket;
	private Item toy;

	@Before
	public void setup() {
		toy = new Item("toy", 39.99);
		basket = new Basket();
	}

	@Test
	public void shouldAllowToAddItemToBasket() {
		basket.add(toy);

		Map<Item, Integer> expected = createOrder(toy, 1);

		assertEquals(expected, basket.getOrder());
	}

	@Test
	public void shouldAllowToAddTheSameItemTwice() {
		basket.add(toy);
		basket.add(toy);

		Map<Item, Integer> expected = createOrder(toy, 2);

		assertEquals(expected, basket.getOrder());
	}

	@Test
	public void shouldAllowToAddItemWithQuantityOne() {
		basket.add(toy, 1);

		Map<Item, Integer> expected = createOrder(toy, 1);

		assertEquals(expected, basket.getOrder());
	}

	@Test
	public void shouldAllowToAddItemWithQuantityMany() {
		basket.add(toy, 34);

		Map<Item, Integer> expected = createOrder(toy, 34);

		assertEquals(expected, basket.getOrder());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldntAllowToAddItemWithQuantityZero() {
		basket.add(toy, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldntAllowToAddItemWithNegativeQuantity() {
		basket.add(toy, -10);
	}

	@Test
	public void shouldAllowToRemoveItemFromBasket() {
		basket.add(toy, 2);
		basket.remove(toy);

		Map<Item, Integer> expected = createOrder(toy, 1);

		assertEquals(expected, basket.getOrder());
	}

	@Test
	public void shouldRemoveAllItemsFromBasket() {
		basket.add(toy);
		basket.remove(toy);

		Map<Item, Integer> expected = Collections.emptyMap();

		assertEquals(expected, basket.getOrder());
	}

	@Test
	public void shouldAllowToRemove2ItemsAtOnce() {
		basket.add(toy, 3);
		basket.remove(toy, 2);

		Map<Item, Integer> expected = createOrder(toy, 1);

		assertEquals(expected, basket.getOrder());
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenRemoving0Items() {
        basket.remove(toy, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenRemovingNegativeQuantity() {
        basket.remove(toy, -10);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenThereIsNoThatManyItemsToRemove() {
        basket.add(toy, 1);
        basket.remove(toy, 2);
    }
    
    @Test
    public void shouldComputeSimpleOrderValue() {
        basket.add(toy, 3);

        double expectedValue = toy.getPrice() * 3;

        assertEquals(expectedValue, basket.getOrderValue(), PRICE_DELTA);
    }
    
    @Test
    public void shouldComputeOrderWithManyItemsValue() {
        Item teddyBear = new Item("teddy bear", 59.99);
        basket.add(toy, 3);
        basket.add(teddyBear, 4);

        double expectedValue = toy.getPrice() * 3 + teddyBear.getPrice() * 4;

        assertEquals(expectedValue, basket.getOrderValue(), PRICE_DELTA);
    }

	private static Map<Item, Integer> createOrder(Object... mapContent) {
		Map<Item, Integer> result = new HashMap<>();

		for (int index = 0; index < mapContent.length; index += 2) {
			Item item = (Item) mapContent[index];
			Integer quantity = (Integer) mapContent[index + 1];
			result.put(item, quantity);
		}

		return result;
	}

}
