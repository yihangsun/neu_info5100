public class Professor {
	private String firstName;
	private String lastName;
	private int id;
	
	private String email;
	private Course courses;
	private Student[] students = new Student[] {};
	
	public static class Builder {
		private String firstName;
		private String lastName;
		private int id;
		
		private String email;
		private Course courses;
		private Student[] students = new Student[] {};
		
		public Builder(String firstName, String lastName, int id) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder teachingCourse(Course courses) {
			this.courses = courses;
			return this;
		}
		
		public Builder teachingStudents(Student[] students) {
			this.students = students;
			return this;
		}
		
		public Professor build() {
			return new Professor (firstName, lastName, id, email, courses, students);
		}
	}
	
	public Professor(String firstName, String lastName, int id, String email, Course courses, Student[] students) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.courses = courses;
		this.students = students;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return firstName + lastName;
	}
	
	public int getID() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Course getCourse() {
		return courses;
	}
	
	public Student[] getStudents() {
		return students;
	}
}
