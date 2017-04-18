import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] stations = new int[m];
		for (int i = 0; i < stations.length; i++) {
			stations[i] = sc.nextInt();
		}
		System.out.println(solve(n, stations));

		sc.close();
	}

	static int solve(int n, int[] stations) {
		Arrays.sort(stations);

		int maxDistance = Math.max(stations[0], n - 1 - stations[stations.length - 1]);
		for (int i = 0; i + 1 < stations.length; i++) {
			maxDistance = Math.max(maxDistance, (stations[i + 1] - stations[i]) / 2);
		}
		return maxDistance;
	}
}
