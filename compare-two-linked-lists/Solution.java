class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method

	int CompareLists(Node headA, Node headB) {
		while (headA != null && headB != null) {
			if (headA.data != headB.data) {
				return 0;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return headA == headB ? 1 : 0;
	}
}
