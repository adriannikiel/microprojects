package pl.anikiel.shop;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void twoItemsWithTheSamePriceAndNameShouldBeEqual() {
		assertEquals(new Item("item", 123.45), new Item("item", 123.45));
	}

	@Test
	public void itemsWithDifferentNamesArentEqual() {
		assertNotEquals(new Item("item1", 123.45), new Item("item2", 123.45));
	}

	@Test
	public void itemsWithDifferentPriceArentEqual() {
		assertNotEquals(new Item("item", 123.45), new Item("item", 123.65));
	}

	@Test
	public void itemsWithTheSameNameShouldHaveTheSameHashCode() {
		assertEquals(new Item("item", 123.45).hashCode(), new Item("item", 123.65).hashCode());
	}

	@Test
	public void itemsWithDifferentNameShouldHaveDifferentHashCode() {
		assertNotEquals(new Item("item1", 123.45).hashCode(), new Item("item2", 123.45).hashCode());
	}

	@Test
	public void itemsWithTheSamePriceAndTheSameNameShouldntBeOrdered() {
		assertEquals(0, new Item("item", 123.45).compareTo(new Item("item", 123.45)));
	}

	@Test
	public void itemsWithDifferentPriceAndTheSameNameShouldNotBeOrdered_FirstPriceHigher() {
		assertEquals(1, new Item("item", 123.65).compareTo(new Item("item", 123.45)));
	}

	@Test
	public void itemsWithDifferentPriceAndTheSameNameShouldBeOrdered_SecondPriceHigher() {
		assertEquals(-1, new Item("item", 123.45).compareTo(new Item("item", 123.65)));
	}

	@Test
	public void itemsWithTheSamePriceAndDifferentNameShouldNotBeOrdered_FirstNameHigher() {
		assertEquals(1, new Item("itemB", 123.45).compareTo(new Item("itemA", 123.45)));
	}

	@Test
	public void itemsWithTheSamePriceAndDifferentNameShouldBeOrdered_SecondtNameHigher() {
		assertEquals(-1, new Item("itemA", 123.45).compareTo(new Item("itemB", 123.45)));
	}

}
