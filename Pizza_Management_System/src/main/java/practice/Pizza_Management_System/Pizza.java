package practice.Pizza_Management_System;

public class Pizza {
	private int order_Id, quantity;
	private String pizza_Name;
	private double price, amount;

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPizza_Name() {
		return pizza_Name;
	}

	public void setPizza_Name(String pizza_Name) {
		this.pizza_Name = pizza_Name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
