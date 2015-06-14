class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.
	Node Reverse(Node head) {
		Node tempHead = new Node();

		while (head != null) {
			Node node = head;
			head = node.next;
			node.next = tempHead.next;
			tempHead.next = node;
		}

		return tempHead.next;
	}
}
