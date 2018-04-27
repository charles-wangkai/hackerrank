import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();

			Rational result = solve(A, B, C);
			System.out.println(String.format("%d/%d", result.numerator, result.denominator));
		}

		sc.close();
	}

	static Rational solve(int A, int B, int C) {
		if (A > B) {
			return solve(B, A, C);
		}

		if (C >= A + B) {
			return new Rational(1, 1);
		}

		Rational height = new Rational(1, B);

		if (C <= A) {
			Rational r = new Rational(C, A);
			return Rational.multiply(Rational.multiply(r, r), Rational.multiply(new Rational(A, 2), height));
		} else if (C <= B) {
			return Rational.add(Rational.multiply(new Rational(A, 2), height),
					Rational.multiply(new Rational(C - A, 1), height));
		} else {
			Rational r = new Rational(A + B - C, A);
			return Rational.subtract(new Rational(1, 1),
					Rational.multiply(Rational.multiply(r, r), Rational.multiply(new Rational(A, 2), height)));
		}
	}
}

class Rational {
	long numerator;
	long denominator;

	Rational(long numerator, long denominator) {
		long g = gcd(numerator, denominator);

		this.numerator = numerator / g;
		this.denominator = denominator / g;
	}

	long gcd(long x, long y) {
		return (y == 0) ? x : gcd(y, x % y);
	}

	static Rational multiply(Rational r1, Rational r2) {
		return new Rational(r1.numerator * r2.numerator, r1.denominator * r2.denominator);
	}

	static Rational add(Rational r1, Rational r2) {
		return new Rational(r1.numerator * r2.denominator + r2.numerator * r1.denominator,
				r1.denominator * r2.denominator);
	}

	static Rational subtract(Rational r1, Rational r2) {
		return new Rational(r1.numerator * r2.denominator - r2.numerator * r1.denominator,
				r1.denominator * r2.denominator);
	}
}