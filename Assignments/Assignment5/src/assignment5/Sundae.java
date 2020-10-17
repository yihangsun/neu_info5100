package assignment5;

public class Sundae extends IceCream {
	
	private String toppingName;
	private int toppingPrice;
	
	public Sundae(String IceCreamName, int IceCreamPrice, String toppingName, int toppingPrice) {
		super(IceCreamName, IceCreamPrice);
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;
	}
	
	public String getTopping() {
		return toppingName;
	}
	
	public int getCost() {
		return super.getCost() + toppingPrice;
	}
}
