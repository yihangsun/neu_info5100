package assignment5;
import java.util.*;

public class Checkout {
	
	private Vector<DessertItem> vector;
	
	public Checkout() {
		vector = new Vector<DessertItem>();
	}
	
	public int numberOfItems() {
		return vector.size();
	}
	
	public void enterItem(DessertItem desserts) {
		vector.add(desserts);
	}
	
	public void clear() {
		vector.clear();
	}
	
	public int totalCost() {
		int totalCost = 0;
		for (DessertItem dessert : vector) {
			totalCost += dessert.getCost();
		}
		return totalCost;
	}
	
	public int totalTax() {
		return (int) Math.round(totalCost() * DessertShoppe.TAX / 100);
	}
	
	public String toString() {
		// generate title 
		String result = "";
		int paperSize = DessertShoppe.MAX_ITEM_NAME_LENGTH + DessertShoppe.WIDTH_DISPLAYING_COSTS_OF_ITEMS;
		String titleSpace = " ".repeat((paperSize - DessertShoppe.STORE_NAME.length()) / 2);
		String dash = "_".repeat(DessertShoppe.STORE_NAME.length());
		result = titleSpace + DessertShoppe.STORE_NAME + titleSpace + "\n" 
				+ titleSpace + dash + titleSpace + "\n";
		
		for (DessertItem item : vector) {
			result += "\n";
			String line = "";
			String price = checkOverSize(DessertShoppe.cents2dollarsAndCents(item.getCost()), DessertShoppe.WIDTH_DISPLAYING_COSTS_OF_ITEMS);
			String itemName = checkOverSize(item.getName(), DessertShoppe.MAX_ITEM_NAME_LENGTH);
			if (item instanceof Candy) {
				line = ((Candy) item).getWeight() + " lbs. @ " + ((Candy)item).getPricePerPound() / 100.00 + " /lb." + "\n";
				line = checkOverSize(line, paperSize);
				result += line;
				line = itemName + " ".repeat(paperSize - itemName.length() - price.length()) + price;
			} else if (item instanceof Cookie) {
				line = ((Cookie) item).getNumber() + " @ " + ((Cookie) item).getPricePerDozen() / 100.00 + " /dz." + "\n";
				line = checkOverSize(line, paperSize);
				result += line;
				line = itemName + " ".repeat(paperSize - itemName.length() - price.length()) + price;
			} else if (item instanceof Sundae) {
				line = ((Sundae) item).getTopping() + " Sundae with" + "\n" + itemName + " ".repeat(paperSize - itemName.length() - price.length()) + price;
			} else {
				line = itemName +  " ".repeat(paperSize - itemName.length() - price.length()) + price;
			}
			result += line;
		}
		String tax2String = DessertShoppe.cents2dollarsAndCents(totalTax());
		String total2String = DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax());
		result = result + "\n" + "Tax " + " ".repeat(paperSize - tax2String.length() - 4) + tax2String + "\n" + "Total Cost " + " ".repeat(paperSize - total2String.length() - "Total Cost ".length()) + total2String;
		return result;
	}

	// if over sized, cut to the limit size - 1 index, and add exceed string at another line
	private String checkOverSize(String line, int limit) {
		if (line.length() > limit) {
			String exceed = line.substring(limit, line.length());
			line = line.substring(0, limit) + "\n" + exceed;
		}
		return line;
	}
}
