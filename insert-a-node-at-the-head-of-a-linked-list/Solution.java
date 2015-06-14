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

	Node Insert(Node head, int x) {
		Node node = new Node();
		node.data = x;
		node.next = head;
		return node;
	}
}
