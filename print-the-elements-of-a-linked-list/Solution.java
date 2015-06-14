//  Print elements of a linked list on console 
//  head pointer input could be NULL as well for empty list
//  Node is defined as 
class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method.

	void Print(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.println(node.data);
		}
	}
}
