import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		System.out.println(solve(A, K));

		sc.close();
	}

	static int solve(int[] A, int K) {
		PriorityQueue<Integer> sweetnesses = new PriorityQueue<>(Arrays.stream(A).boxed().collect(Collectors.toList()));

		int operationNum = 0;
		while (sweetnesses.peek() < K && sweetnesses.size() >= 2) {
			int leastSweetness = sweetnesses.poll();
			int secondLeastSweetness = sweetnesses.poll();

			sweetnesses.add(leastSweetness + 2 * secondLeastSweetness);
			operationNum++;
		}

		return (sweetnesses.peek() >= K) ? operationNum : -1;
	}
}
