import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(String.join(" ", solve(a).stream().map(Object::toString).collect(Collectors.toList())));

		sc.close();
	}

	static List<Integer> solve(int[] a) {
		int sum = Arrays.stream(a).sum();

		List<Integer> sizes = new ArrayList<Integer>();
		for (int i = 1; i * i <= sum; i++) {
			if (sum % i == 0) {
				if (isValid(a, i)) {
					sizes.add(i);
				}

				if (i * i != sum) {
					if (isValid(a, sum / i)) {
						sizes.add(sum / i);
					}
				}
			}
		}
		Collections.sort(sizes);
		return sizes;
	}

	static boolean isValid(int[] a, int size) {
		int remain = size;
		for (int oneA : a) {
			if (remain == oneA) {
				remain = size;
			} else if (remain < oneA) {
				return false;
			} else {
				remain -= oneA;
			}
		}
		return remain == size;
	}
}
