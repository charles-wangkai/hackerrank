import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SortedSet<Integer> elements = new TreeSet<>();
		int Q = sc.nextInt();
		for (int tc = 0; tc < Q; tc++) {
			int type = sc.nextInt();

			if (type == 3) {
				System.out.println(elements.first());
			} else {
				int v = sc.nextInt();

				if (type == 1) {
					elements.add(v);
				} else if (type == 2) {
					elements.remove(v);
				}
			}
		}

		sc.close();
	}
}
