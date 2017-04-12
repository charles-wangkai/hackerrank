import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, d));

		sc.close();
	}

	static int solve(int[] a, int d) {
		Set<Integer> numbers = Arrays.stream(a).collect(HashSet<Integer>::new, Set<Integer>::add, Set<Integer>::addAll);
		return (int) Arrays.stream(a).filter(x -> numbers.contains(x + d) && numbers.contains(x + d * 2)).count();
	}
}
