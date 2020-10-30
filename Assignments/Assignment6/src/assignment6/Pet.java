package assignment6;

public class Pet {
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int SPAYED = 3;
	public static final int NEUTERED = 4;
	
	private String name;
	private String ownerName;
	private String color;
	protected int sexid;
	
	public Pet(String name, String ownerName, String color) {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	public String getPetName() {
		return name;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setSex(int sexid) {
		this.sexid = sexid;
	}
	
	public String getSex() {
		switch(sexid) {
		case MALE: 
			return "MALE";
		case FEMALE:
			return "FEMALE";
		case SPAYED:
			return "SPAYED";
		case NEUTERED:
			return "NEUTERED";
		}
		return "";
	}
	
	@Override
	public String toString() {
		return name + " owned by " + ownerName + "\n" + "Color: " + color + "\n" + "Sex: " + getSex(); 
	}
}
