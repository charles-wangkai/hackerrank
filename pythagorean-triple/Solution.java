import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		PythagoreanTriple pt = solve(a);
		System.out.println(String.format("%d %d %d", pt.a, pt.b, pt.c));

		sc.close();
	}

	static PythagoreanTriple solve(int a) {
		if (a % 2 == 0) {
			int m = a / 2;
			int n = 1;
			return new PythagoreanTriple(a, square(m) - square(n), square(m) + square(n));
		} else {
			long k = (square(a) - 1) / 2;
			return new PythagoreanTriple(a, k, k + 1);
		}
	}

	static long square(int x) {
		return (long) x * x;
	}
}

class PythagoreanTriple {
	long a;
	long b;
	long c;

	PythagoreanTriple(long a, long b, long c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}