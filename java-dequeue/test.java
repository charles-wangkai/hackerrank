import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int maxUniqueNum = 0;
		int uniqueNum = 0;
		for (int i = 0; i < N; i++) {
			int number = sc.nextInt();

			if (deque.size() == M - 1) {
				uniqueNum = computeUniqueNum(deque);
			}
			if (deque.size() >= M - 1) {
				if (!deque.contains(number)) {
					uniqueNum++;
				}
			}
			deque.offerLast(number);

			if (deque.size() > M) {
				int polled = deque.pollFirst();
				if (!deque.contains(polled)) {
					uniqueNum--;
				}
			}

			maxUniqueNum = Math.max(maxUniqueNum, uniqueNum);
		}
		System.out.println(maxUniqueNum);

		sc.close();
	}

	static int computeUniqueNum(Deque<Integer> deque) {
		return new HashSet<Integer>(deque).size();
	}
}
