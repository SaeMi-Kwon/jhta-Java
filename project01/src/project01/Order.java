package project01;


public class Order {
	private String item;
	private int price;
	private int amount;
	private int total;
	
	
	public Order(String item, int price, int amount) {
		this.item = item;
		this.price = price;
		this.amount = amount;
		this.total = price*amount;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return item + ", " + amount + "개, " + total +"원";
	}
	

}
