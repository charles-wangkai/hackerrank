import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();
		@SuppressWarnings("unchecked")
		List<Integer>[] seqList = new List[N];
		for (int i = 0; i < seqList.length; i++) {
			seqList[i] = new ArrayList<Integer>();
		}
		int lastAnswer = 0;
		for (int i = 0; i < Q; i++) {
			int type = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (type == 1) {
				seqList[(x ^ lastAnswer) % N].add(y);
			} else if (type == 2) {
				List<Integer> seq = seqList[(x ^ lastAnswer) % N];
				lastAnswer = seq.get(y % seq.size());
				System.out.println(lastAnswer);
			}
		}

		sc.close();
	}
}
