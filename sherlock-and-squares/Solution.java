import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int A = in.nextInt();
			int B = in.nextInt();

			System.out.println(Math.max(0, sqrtToFloor(B) - sqrtToCeil(A) + 1));
		}

		in.close();
	}

	static int sqrtToNearest(int number) {
		return (int) Math.round(Math.sqrt(number));
	}

	static int sqrtToFloor(int number) {
		int result = sqrtToNearest(number);
		if (result * result > number) {
			result--;
		}
		return result;
	}

	static int sqrtToCeil(int number) {
		int result = sqrtToNearest(number);
		if (result * result < number) {
			result++;
		}
		return result;
	}
}