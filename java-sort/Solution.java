import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static final double ERROR = 1E-9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Student[] students = new Student[N];
		for (int i = 0; i < students.length; i++) {
			int id = sc.nextInt();
			String name = sc.next();
			double cgpa = sc.nextDouble();

			students[i] = new Student(id, name, cgpa);
		}

		Arrays.sort(students,
				(student1, student2) -> Math.abs(student1.cgpa - student2.cgpa) > ERROR
						? (int) Math.signum(student2.cgpa - student1.cgpa)
						: (student1.name.equals(student2.name) ? (student1.id - student2.id)
								: student1.name.compareTo(student2.name)));

		for (Student student : students) {
			System.out.println(student.name);
		}

		sc.close();
	}
}

class Student {
	int id;
	String name;
	double cgpa;

	Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
}