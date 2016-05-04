import java.util.Scanner;

//Write your code here
class Calculator {
	int power(int n, int p) throws Exception {
		if (n < 0 || p < 0) {
			throw new Exception("n and p should be non-negative");
		}

		int result = 1;
		for (int i = 0; i < p; i++) {
			result *= n;
		}
		return result;
	}
}

class Solution {

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int p = in.nextInt();
			Calculator myCalculator = new Calculator();
			try {
				int ans = myCalculator.power(n, p);
				System.out.println(ans);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		in.close();
	}
}
