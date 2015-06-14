import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int V = in.nextInt();
		int n = in.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
		}

		for (int i = 0;; i++) {
			if (numbers[i] == V) {
				System.out.println(i);
				break;
			}
		}

		in.close();
	}
}
