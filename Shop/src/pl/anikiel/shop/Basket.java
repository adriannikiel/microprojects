package pl.anikiel.shop;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
	private final Map<Item, Integer> order = new TreeMap<>();

	public void add(Item item) {
		add(item, 1);
	}

	public void add(Item item, int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException(String.format("Illegal quantity %d", quantity));
		}

		if (order.containsKey(item)) {
			quantity = order.get(item) + quantity;
		}

		order.put(item, quantity);
	}

	public void remove(Item item) {
		remove(item, 1);
	}

	public void remove(Item item, int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException(String.format("Illegal quantity %d!", quantity));
		}

		if (order.containsKey(item)) {
			quantity = order.get(item) - quantity;
		}

		if (quantity == 0) {
			order.remove(item);
		} else if (quantity < 0) {
			throw new IllegalStateException(String.format("There is no that many items to remove~"));
		} else {
			order.put(item, quantity);
		}
	}

	public Map<Item, Integer> getOrder() {
		return Collections.unmodifiableMap(order);
	}

	public double getOrderValue() {
		double orderValue = 0;

		for (Map.Entry<Item, Integer> itemOrder : order.entrySet()) {
			orderValue += itemOrder.getValue() * itemOrder.getKey().getPrice();
		}

		return orderValue;
	}

}
