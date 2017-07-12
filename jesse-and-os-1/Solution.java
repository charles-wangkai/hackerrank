import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static long timeTaken(int num, int memo, long[] dur, long[] mem) {
		long time = 0;
		long memleft = memo;
		PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> ((int) (a[0] - b[0])));

		for (int i = 0; i < num; i++) {
			if (memleft >= mem[i]) {
				long[] tmp = new long[2];

				tmp[0] = time + dur[i];
				tmp[1] = mem[i];

				queue.add(tmp);
				memleft -= mem[i];

			} else {
				long[] tmp = queue.poll();

				time = tmp[0];
				memleft += tmp[1];
				i--;
			}
		}

		while (!queue.isEmpty()) {
			time = queue.poll()[0];
		}

		return time;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		int memo = in.nextInt();

		long[] dur = new long[num];
		long[] mem = new long[num];

		for (int i = 0; i < num; i++) {
			dur[i] = in.nextInt();
			mem[i] = in.nextInt();
		}

		System.out.println(timeTaken(num, memo, dur, mem));

		in.close();
	}
}
