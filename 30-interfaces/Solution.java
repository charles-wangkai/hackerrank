import java.util.Scanner;

interface AdvancedArithmetic {
	int divisorSum(int n);
}

// Write your code here
class Calculator implements AdvancedArithmetic {
	@Override
	public int divisorSum(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				result += i;
			}
		}
		return result;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		AdvancedArithmetic myCalculator = new Calculator();
		int sum = myCalculator.divisorSum(n);
		System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}

}
