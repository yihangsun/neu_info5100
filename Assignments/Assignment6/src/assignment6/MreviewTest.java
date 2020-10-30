package assignment6;
// For main(), you create at least 1 Mreview object and add 3 ratings, 
// then print the object by calling the toString() method and its average 
// rating by calling the aveRating() method.

public class MreviewTest {
	public static void main(String[] args) {
		Mreview movieA = new Mreview("Sleepless in Seattle", 5);
		movieA.addRating(4);
		movieA.addRating(4);
		System.out.println(movieA.toString());
		
		Mreview movieB = new Mreview("Lion King");
		movieB.addRating(3);
		movieB.addRating(5);
		movieB.addRating(2);
		System.out.println(movieB.equals(movieA));
		System.out.println(movieB.compareTo(movieA));
		System.out.println(movieB.toString());
	}
}
