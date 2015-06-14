class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.

	Node Insert(Node head, int x) {
		Node node = new Node();
		node.data = x;
		node.next = head;
		return node;
	}
}
