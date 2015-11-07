import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student {
	private String name;
	@SuppressWarnings("unused")
	private String id;
	@SuppressWarnings("unused")
	private String email;

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void anothermethod() {
	}

	// ......
	// ......
	// some more methods
	// ......
}

public class Solution {
	public static void main(String[] args) {
		Class<Student> student = Student.class;
		Method[] methods = student.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<>();
		for (Method method : methods) {
			methodList.add(method.getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
	}
}
