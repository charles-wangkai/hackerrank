
// https://math.stackexchange.com/questions/124408/finding-a-primitive-root-of-a-prime-number/133720#133720

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		Answer answer = solve(p);
		System.out.printf("%d %d\n", answer.minPrimitiveRoot, answer.primitiveRootNum);

		sc.close();
	}

	static Answer solve(int p) {
		int s = p - 1;
		List<Integer> primeFactors = buildPrimeFactors(s);

		int minPrimitiveRoot = 2;
		while (!isPrimitiveRoot(p, primeFactors, minPrimitiveRoot)) {
			minPrimitiveRoot++;
		}

		int primitiveRootNum = computeTotient(s, primeFactors);

		return new Answer(minPrimitiveRoot, primitiveRootNum);
	}

	static boolean isPrimitiveRoot(int p, List<Integer> primeFactors, int a) {
		int s = p - 1;
		for (int primeFactor : primeFactors) {
			if (powMod(a, s / primeFactor, p) == 1) {
				return false;
			}
		}
		return true;
	}

	static int powMod(int base, int exponent, int modDivisor) {
		int result = 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = multiplyMod(result, base, modDivisor);
			}

			base = multiplyMod(base, base, modDivisor);
			exponent /= 2;
		}
		return result;
	}

	static int multiplyMod(int x, int y, int modDivisor) {
		return (int) ((long) x * y % modDivisor);
	}

	static List<Integer> buildPrimeFactors(int n) {
		List<Integer> primeFactors = new ArrayList<>();

		for (int i = 2; i * i <= n; i++) {
			if (isPrime(i) && n % i == 0) {
				primeFactors.add(i);

				while (n % i == 0) {
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

	static int computeTotient(int n, List<Integer> primeFactors) {
		int result = n;
		for (int primeFactor : primeFactors) {
			result = result / primeFactor * (primeFactor - 1);
		}
		return result;
	}
}

class Answer {
	int minPrimitiveRoot;
	int primitiveRootNum;

	Answer(int minPrimitiveRoot, int primitiveRootNum) {
		this.minPrimitiveRoot = minPrimitiveRoot;
		this.primitiveRootNum = primitiveRootNum;
	}
}