

public class Test {
	
	public static void main(String[] args) {
		// load basic information
		Student studentA = new Student("Tina", 1);
		Student studentB = new Student("Haosen", 2);
		Student studentC = new Student("Belinda", 3);
		Course infoA = new Course("info5100");
		// try to print basic information
		System.out.println(studentA.getName());
		System.out.println(studentB.getId());
		System.out.println(studentC.getName() + ' ' + studentC.getId());
		System.out.println(infoA.getName() + ' ' + infoA.getNumberOfStudent());
		
		// add another course and assign students
		Course infoB = new Course("info6210");
		infoB.registerStudent(studentA);
		infoA.registerStudent(studentB);
		infoA.registerStudent(studentC);
		System.out.println(infoA.getName() + " " + infoA.isFull());
		System.out.println(infoB.getName() + " " + infoB.getNumberOfStudent());
		System.out.println(infoA.getName() + " " + infoA.getNumberOfStudent());
		
		// add more students to test getNumberOfStudent and getStudents
		infoA.registerStudent(new Student("Siva", 200));
		infoA.registerStudent(new Student("Lily", 100));
		infoA.registerStudent(new Student("Lolo", 150));
		infoA.registerStudent(new Student("Lala", 90));
		infoA.registerStudent(new Student("Haha", 80));
		infoA.registerStudent(new Student("Lion", 70));
		for (int i = 0; i < infoA.getNumberOfStudent(); i++) {
			System.out.println(infoA.getStudents()[i].getName());
		}
		
		//extra credit testing
		Professor siva = new Professor.Builder("Tina", "Sun", 122)
				.setEmail("tinasun@gmail.com")
				.teachingCourse(infoA)
				.teachingStudents(infoA.getStudents())
				.build();
		System.out.println(siva.getEmail());
		System.out.println(siva.getName());
		for (int i = 0; i < siva.getCourse().getNumberOfStudent(); i++) {
			System.out.println(siva.getCourse().getStudents()[i].getName());
		}
	}
}
