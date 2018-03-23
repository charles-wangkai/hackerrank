import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		int minDiff = Integer.MAX_VALUE;
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < a.length - 1; i++) {
			int diff = a[i + 1] - a[i];
			if (diff < minDiff) {
				minDiff = diff;
				indices.clear();
				indices.add(i);
			} else if (diff == minDiff) {
				indices.add(i);
			}
		}

		for (int i = 0; i < indices.size(); i++) {
			if (i != 0) {
				System.out.print(" ");
			}

			System.out.print(a[indices.get(i)] + " " + a[indices.get(i) + 1]);
		}

		sc.close();
	}
}
