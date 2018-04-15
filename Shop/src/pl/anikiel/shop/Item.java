package pl.anikiel.shop;

public class Item implements Comparable<Item> {

	private final String name;
	private final double price;

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || !(obj instanceof Item)) {
			return false;
		}

		Item item = (Item) obj;

		if (Double.compare(item.price, price) != 0) {
			return false;
		}

		return name.equals(item.name);
	}

	@Override
	public int hashCode() {
		return 17 * name.hashCode();
	}

	@Override
	public int compareTo(Item other) {
		if (other == null) {
			return 1;
		}

		int comparison = this.getName().compareTo(other.getName());

		if (comparison != 0) {
			return comparison;
		}

		return Double.compare(this.getPrice(), other.getPrice());
	}

}
