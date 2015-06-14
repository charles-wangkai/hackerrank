class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.

	Node Delete(Node head, int position) {
		Node tempHead = new Node();
		tempHead.next = head;

		Node prev = tempHead;
		for (int i = 0; i < position; i++) {
			prev = prev.next;
		}
		prev.next = prev.next.next;

		return tempHead.next;
	}
}
