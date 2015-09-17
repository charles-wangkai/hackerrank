import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = in.nextInt();
		}

		partition(ar);

		in.close();
	}

	static void partition(int[] ar) {
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] < ar[0]) {
				left.add(ar[i]);
			} else {
				right.add(ar[i]);
			}
		}

		List<Integer> partitioned = new ArrayList<Integer>();
		partitioned.addAll(left);
		partitioned.add(ar[0]);
		partitioned.addAll(right);

		printNumbers(partitioned);
	}

	static void printNumbers(List<Integer> numbers) {
		System.out.println(String.join(" ", numbers.stream().map(String::valueOf).collect(Collectors.toList())));
	}
}
