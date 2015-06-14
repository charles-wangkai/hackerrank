class Node {
	int data;
	Node next;
	Node prev;
}

public class Solution {
	Node SortedInsert(Node head, int data) {
		Node tempHead = new Node();
		tempHead.next = head;

		Node prev = tempHead;
		while (prev.next != null && prev.next.data < data) {
			prev = prev.next;
		}
		Node node = new Node();
		node.data = data;
		node.next = prev.next;
		if (prev.next != null) {
			prev.next.prev = node;
		}
		node.prev = prev;
		prev.next = node;

		return tempHead.next;
	}
}
