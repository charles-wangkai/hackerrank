import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> uppers = new PriorityQueue<Integer>();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int ai = sc.nextInt();

			if (!lowers.isEmpty() && ai <= lowers.peek()) {
				lowers.offer(ai);
			} else {
				uppers.offer(ai);
			}

			while (lowers.size() > uppers.size()) {
				uppers.offer(lowers.poll());
			}
			while (uppers.size() - lowers.size() > 1) {
				lowers.offer(uppers.poll());
			}

			double median;
			if (lowers.size() == uppers.size()) {
				median = (lowers.peek() + uppers.peek()) / 2.0;
			} else {
				median = uppers.peek();
			}
			System.out.printf("%.1f\n", median);
		}

		sc.close();
	}
}
