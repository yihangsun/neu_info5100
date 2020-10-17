package assignment5;

public class DessertShoppe {
	public static final double TAX = 6.5;
	public static final String STORE_NAME = "M & M Dessert Shoppe";
	public static final int MAX_ITEM_NAME_LENGTH = 25;
	public static final int WIDTH_DISPLAYING_COSTS_OF_ITEMS = 5;
	
	public static String cents2dollarsAndCents(int cents) {
		double dollar = cents / 100.00;
		return "" + dollar;
	}
}
