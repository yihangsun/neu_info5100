package assignment6;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Cat extends Pet implements Boardable{
	private String hairLength;
	private LocalDate boardStart, boardEnd;
	
	public Cat(String name, String ownerName, String color, String hairLength) {
		super(name, ownerName, color);
		this.hairLength = hairLength;
	}
	
	public String getHairLength() {
		return hairLength;
	}
	
	@Override
	public String toString() {
		return "CAT:" + "\n" + super.toString() + "\n" + "Hair: " + hairLength;
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
