package assignment5;

public class Candy extends DessertItem{
	
	private double weight;
	private int pricePerPound;
	
	public Candy(String name, double weight, int pricePerPound) {
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getPricePerPound() {
		return pricePerPound;
	}
	
	public int getCost() {
		return (int) Math.round(weight * pricePerPound);
	}
}
