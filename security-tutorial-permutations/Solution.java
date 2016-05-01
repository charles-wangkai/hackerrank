import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[n + 1];
		for (int x = 1; x <= n; x++) {
			f[x] = sc.nextInt();
		}

		IntStream.range(1, n + 1).forEach(x -> System.out.println(f[f[x]]));

		sc.close();
	}
}
