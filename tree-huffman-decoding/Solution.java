class Node {
	public int frequency; // the frequency of this tree
	public char data;
	public Node left, right;
}

public class Solution {
	void decode(String S, Node root) {
		Node node = root;
		for (char ch : S.toCharArray()) {
			if (ch == '0') {
				node = node.left;
			} else {
				node = node.right;
			}

			if (node.data != 0) {
				System.out.print(node.data);

				node = root;
			}
		}
	}
}
