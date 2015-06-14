//  Insert Node at the end of a linked list 
//  head pointer input could be NULL as well for empty list
//  Node is defined as 
class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.

	Node InsertNth(Node head, int data, int position) {
		Node tempHead = new Node();
		tempHead.next = head;

		Node prev = tempHead;
		for (int i = 0; i < position; i++) {
			prev = prev.next;
		}
		Node node = new Node();
		node.data = data;
		node.next = prev.next;
		prev.next = node;

		return tempHead.next;
	}
}
