import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

		in.close();
	}
}
