import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int sum = 0;
		int startIndex = 0;
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			int petrol = in.nextInt();
			int distance = in.nextInt();
			sum += petrol - distance;

			if (sum < 0) {
				sum = 0;
				startIndex = i + 1;
			}
		}
		System.out.println(startIndex);

		in.close();
	}
}
