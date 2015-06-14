class Node {
	int data;
	Node next;
}

public class Solution {
	int HasCycle(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return 1;
			}
		}
		return 0;
	}
}
