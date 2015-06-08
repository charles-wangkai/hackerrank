import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int sumPower2 = 0;
			for (int i = 0; i < n; i++) {
				sumPower2 = sumPower2 * 2 + 1;
				if (i != 0) {
					System.out.print(" ");
				}
				System.out.print(a + sumPower2 * b);
			}
			System.out.println();
		}
		in.close();
	}
}
