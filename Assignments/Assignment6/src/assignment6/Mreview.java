package assignment6;
import java.util.*;

public class Mreview implements Comparable<Mreview> {
	private String title;
	private ArrayList<Integer> ratings;
	
	public Mreview() {
		title = "";
		ratings = new ArrayList<Integer>();
	}
	
	public Mreview(String title) {
		this.title = title;
		ratings = new ArrayList<Integer>();
	}
	
	public Mreview(String title, int firstRating) {
		this.title = title;
		ratings = new ArrayList<Integer>();
		ratings.add(firstRating);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addRating(int rating) {
		ratings.add(rating);
	}
	
	public double aveRating() {
		double sum = 0.0;
		for (int rating : ratings) {
			sum += rating;
		}
		return sum / ratings.size();
	}
	
	public int numRatings() {
		return ratings.size();
	}
	
	@Override
	public int compareTo(Mreview obj) {
		return title.compareTo(obj.getTitle());
	}
	
	public boolean equals(Mreview obj) {
		return title.equals(obj.title);
	}
	
	@Override
	public String toString() {
		return getTitle() + ", average " + aveRating() + " out of " + numRatings() + " ratings.";
	}
}
