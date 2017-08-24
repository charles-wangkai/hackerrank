import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = A.length - 1; i >= 0; i--) {
			System.out.print(A[i]);
			System.out.print(i == 0 ? "\n" : " ");
		}

		sc.close();
	}
}
