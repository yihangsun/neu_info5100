
public class Course {
	private String name;
	private int numberOfStudent;
	private Student[] registeredStudents = new Student[10];
	
	public Course(String name) {
		this.name = name;
	}
	
	public Student[] getStudents() {
		return registeredStudents;
	}
	
	public boolean isFull() {
		if (numberOfStudent == 10) return true;
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	
	public void registerStudent(Student student) {
		if (isFull() != true) {
			registeredStudents[numberOfStudent] = student;
			numberOfStudent++;
		}
	}
}
