import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(solve(N) ? 1 : 0);

		sc.close();
	}

	static boolean solve(int N) {
		List<Integer> primeFactors = factorize(N);
		return computeDigitSum(N) == primeFactors.stream().mapToInt(Solution::computeDigitSum).sum();
	}

	static List<Integer> factorize(int n) {
		List<Integer> primeFactors = new ArrayList<Integer>();
		for (int i = 2; i * i <= n; i++) {
			if (isPrime(i)) {
				while (n % i == 0) {
					primeFactors.add(i);
					n /= i;
				}
			}
		}
		if (n != 1) {
			primeFactors.add(n);
		}
		return primeFactors;
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int computeDigitSum(int n) {
		return String.valueOf(n).chars().map(c -> c - '0').sum();
	}
}
