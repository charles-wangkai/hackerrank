class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.
	Node RemoveDuplicates(Node head) {
		Node node = head;
		while (node != null) {
			if (node.next != null && node.next.data == node.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
}
