import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		SortedMap<Integer, Integer> length2count = new TreeMap<Integer, Integer>();
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			int length = in.nextInt();
			if (!length2count.containsKey(length)) {
				length2count.put(length, 0);
			}
			length2count.put(length, length2count.get(length) + 1);
		}
		int leftNum = N;
		for (int count : length2count.values()) {
			System.out.println(leftNum);
			leftNum -= count;
		}

		in.close();
	}
}
