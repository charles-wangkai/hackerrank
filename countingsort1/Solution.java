import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] counts = new int[100];
		for (int i = 0; i < n; i++) {
			int number = sc.nextInt();
			counts[number]++;
		}

		System.out.println(
				String.join(" ", Arrays.stream(counts).mapToObj(Integer::toString).collect(Collectors.toList())));

		sc.close();
	}
}
