class Node {
	int data;
	Node next;
	Node prev;
}

public class Solution {
	Node Reverse(Node head) {
		Node tempHead = new Node();

		while (head != null) {
			Node node = head;
			head = head.next;
			node.next = tempHead.next;
			if (tempHead.next != null) {
				tempHead.next.prev = node;
			}
			node.prev = null;
			tempHead.next = node;
		}

		return tempHead.next;
	}
}
