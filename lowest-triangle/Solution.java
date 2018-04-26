import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int b = sc.nextInt();
		int a = sc.nextInt();
		System.out.println(solve(b, a));

		sc.close();
	}

	static int solve(int base, int area) {
		return divideToCeil(area * 2, base);
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
