import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solve(arr, k));

		sc.close();
	}

	static int solve(int[] arr, int k) {
		Set<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toSet());

		return (int) Arrays.stream(arr).filter(number -> numbers.contains(number + k)).count();
	}
}
