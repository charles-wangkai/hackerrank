import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int MAX_BIT_INDEX = 30;

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node trie = new Node();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			addToTrie(trie, a, MAX_BIT_INDEX);
		}

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int optimalA = searchOptimalA(trie, x, MAX_BIT_INDEX, 0);

			sb.append(x ^ optimalA).append("\n");
		}
		System.out.print(sb);
	}

	static int searchOptimalA(Node node, int x, int bitIndex, int a) {
		if (bitIndex == -1) {
			return a;
		}

		int xDigit = getDigit(x, bitIndex);
		for (int aDigit : new int[] { 1 - xDigit, xDigit }) {
			if (node.digitToChild[aDigit] != null) {
				return searchOptimalA(node.digitToChild[aDigit], x, bitIndex - 1, a * 2 + aDigit);
			}

			aDigit = 1 - aDigit;
		}
		return -1;
	}

	static void addToTrie(Node node, int number, int bitIndex) {
		int digit = getDigit(number, bitIndex);

		if (node.digitToChild[digit] == null) {
			node.digitToChild[digit] = new Node();
		}

		if (bitIndex >= 1) {
			addToTrie(node.digitToChild[digit], number, bitIndex - 1);
		}
	}

	static int getDigit(int p, int bitIndex) {
		return (p & (1 << bitIndex)) == 0 ? 0 : 1;
	}
}

class Node {
	Node[] digitToChild = new Node[2];
}