package model;

public class CartItems extends Product {
	private int quantity;

	public CartItems() {
		super();
	}

	public CartItems(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
