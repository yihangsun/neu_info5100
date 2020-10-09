package Assignment4;

//Constructed a Circle with Circle()
//Run of the program should produce the following output:
//Radius is 2.0, Color is yellow, Base area is (your answer)

//Constructed a Cylinder with Cylinder()
//Run of the program should produce the following output:
//Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)
//Solution: Radius is 2.0, Color is yellow, Base area is 12.566370614359172

//Constructed a Cylinder with Cylinder(height, radius)
//Run of the program should produce the following output:
//Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
// Solution: Radius is 2.0, Height is 5.0, Color is red, Base area is 12.566370614359172, Volume is 62.83185307179586

public class TestCyliner {
	public static void main(String[] args) {
		Circle circle = new Circle(2.0, "yellow");
		System.out.println("Radius is 2.0, Color is yellow, Base area is " + circle.getArea());
		
		Cylinder cylinder = new Cylinder();
		cylinder.setRadius(2.0);
		cylinder.setColor("red");
		cylinder.setHeight(5.0);
		System.out.println("Radius is 2.0, Height is 5.0, Color is red, Base area is " + circle.getArea() + ", Volume is " + cylinder.getVolume());
		
		System.out.println("Radius is 2.0, Height is 5.0, Color is red, Base area is " + circle.getArea() + ", Volume is " + cylinder.getVolume()
		+ ", Area of the cylinder is " + cylinder.getArea());
	}

}
