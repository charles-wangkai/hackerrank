import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int Q = in.nextInt();
		Person[] persons = new Person[N + 1];
		for (int i = 1; i <= N; i++) {
			persons[i] = new Person();
		}

		for (int i = 0; i < Q; i++) {
			String command = in.next();
			if (command.equals("M")) {
				int I = in.nextInt();
				int J = in.nextInt();

				int rootI = findRoot(persons, I);
				int rootJ = findRoot(persons, J);
				if (rootI != rootJ) {
					persons[rootJ].parent = rootI;
					persons[rootI].size += persons[rootJ].size;
				}
			} else if (command.equals("Q")) {
				int I = in.nextInt();

				System.out.println(persons[findRoot(persons, I)].size);
			}
		}

		in.close();
	}

	static int findRoot(Person[] persons, int index) {
		int root = index;
		while (persons[root].parent != -1) {
			root = persons[root].parent;
		}

		int p = index;
		while (p != root) {
			int nextP = persons[p].parent;
			persons[p].parent = root;
			p = nextP;
		}

		return root;
	}
}

class Person {
	int parent = -1;
	int size = 1;
}