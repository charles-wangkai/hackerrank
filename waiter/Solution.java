import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();

		Stack<Integer> A = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			A.push(sc.nextInt());
		}

		int prime = 2;
		for (int i = 0; i < Q; i++) {
			Stack<Integer> B = new Stack<Integer>();
			Stack<Integer> nextA = new Stack<Integer>();
			while (!A.empty()) {
				int number = A.pop();
				if (number % prime == 0) {
					B.push(number);
				} else {
					nextA.push(number);
				}
			}

			printStack(B);
			A = nextA;
			prime = nextPrime(prime);
		}
		printStack(A);

		sc.close();
	}

	static void printStack(Stack<Integer> s) {
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}

	static int nextPrime(int begin) {
		for (int i = begin + 1;; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
