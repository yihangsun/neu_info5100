package assignment6;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Dog extends Pet implements Boardable {
	private String size;
	private LocalDate boardStart, boardEnd;
	
	public Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}
	
	public String getSize() {
		return "DOG:" + "\n" + super.toString() + "\n" + "Size: " + size;
	}
	
	public void setBoardStart(int month, int day, int year) {
		try {
			this.boardStart = LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
			System.out.println("The month will be in the range 1-12, day in the range 1-31, and year will be a four digit number");
		}
	}
	
	public void setBoardEnd(int month, int day, int year) {
		try {
			this.boardEnd = LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
			System.out.println("The month will be in the range 1-12, day in the range 1-31, and year will be a four digit number");
		}
	}
	
	public boolean boarding(int month, int day, int year) {
		LocalDate cur;
		try {
			cur = LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
			System.out.println("The month will be in the range 1-12, day in the range 1-31, and year will be a four digit number");
			return false;
		}
		int checkStarted = cur.compareTo(boardStart);
		int checkEnded = cur.compareTo(boardEnd);
		if (checkStarted >= 0 && checkEnded <= 0) return true;
		return false;
	}
}
