import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int actualD = in.nextInt();
		int actualM = in.nextInt();
		int actualY = in.nextInt();
		int expectedD = in.nextInt();
		int expectedM = in.nextInt();
		int expectedY = in.nextInt();

		int fine = 0;
		if (actualY > expectedY) {
			fine = 10000;
		} else if (actualY == expectedY) {
			if (actualM > expectedM) {
				fine = 500 * (actualM - expectedM);
			} else if (actualM == expectedM) {
				if (actualD > expectedD) {
					fine = 15 * (actualD - expectedD);
				}
			}
		}
		System.out.println(fine);

		in.close();
	}
}
