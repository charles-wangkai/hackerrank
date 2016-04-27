import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String binary = Integer.toBinaryString(n);
		int maxConsecutiveOneNum = 0;
		int consecutiveOneNum = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				consecutiveOneNum++;
				maxConsecutiveOneNum = Math.max(maxConsecutiveOneNum, consecutiveOneNum);
			} else {
				consecutiveOneNum = 0;
			}
		}
		System.out.println(maxConsecutiveOneNum);

		sc.close();
	}
}
