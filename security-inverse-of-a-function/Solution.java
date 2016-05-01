import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] fInvs = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int y = sc.nextInt();
			fInvs[y] = i + 1;
		}

		Arrays.stream(fInvs, 1, fInvs.length).forEach(System.out::println);

		sc.close();
	}
}
