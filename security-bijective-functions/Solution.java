import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Set<Integer> ys = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int y = sc.nextInt();
			ys.add(y);
		}

		System.out.println(ys.size() == n ? "YES" : "NO");

		sc.close();
	}
}
