import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		String binary = Integer.toBinaryString(n);
		int maxConsecutiveOne = 0;
		int consecutiveOne = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				consecutiveOne++;
				maxConsecutiveOne = Math.max(maxConsecutiveOne, consecutiveOne);
			} else {
				consecutiveOne = 0;
			}
		}
		return maxConsecutiveOne;
	}
}
