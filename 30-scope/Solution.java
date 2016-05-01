import java.util.Scanner;

class Difference {
	private int[] elements;
	public int maximumDifference;

	// Add your code here
	Difference(int[] elements) {
		this.elements = elements;
	}

	void computeDifference() {
		for (int i = 0; i < elements.length; i++) {
			for (int j = i + 1; j < elements.length; j++) {
				maximumDifference = Math.max(maximumDifference, Math.abs(elements[i] - elements[j]));
			}
		}
	}
} // End of Difference Class

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		Difference D = new Difference(a);

		D.computeDifference();

		System.out.print(D.maximumDifference);

		sc.close();
	}
}
