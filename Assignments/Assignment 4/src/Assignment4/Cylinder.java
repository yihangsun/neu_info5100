package Assignment4;

public class Cylinder extends Circle{
	double height;
	
	public Cylinder() {
	}
	
	public Cylinder(double height, double radius) {
		super(radius);
		this.height = height;
	}
	
	public Cylinder(double height, double radius, String color) {
		super(radius, color);
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getVolume() {
		return super.getArea() * height;
	}
	
	// Override the getArea() method inherited from superclass Circle; 2πr(r+h)
	@Override
	public double getArea() {
	      return 2 * Math.PI * getRadius() * (getRadius() + height);
	}
}
