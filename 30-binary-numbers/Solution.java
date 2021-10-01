import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int m = sc.nextInt();

		String binary = Integer.toBinaryString(m);
		int maxConsecutiveOneNum = 0;
		int consecutiveOneNum = 0;
		for (int p = 0; p < binary.length(); p++) {
			if (binary.charAt(p) == '1') {
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
