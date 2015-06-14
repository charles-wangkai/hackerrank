class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.
	int GetNode(Node head, int n) {
		int length = findLength(head);
		Node node = head;
		for (int i = 0; i < length - n - 1; i++) {
			node = node.next;
		}
		return node.data;
	}

	int findLength(Node head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
