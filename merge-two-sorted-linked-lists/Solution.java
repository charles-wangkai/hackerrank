class Node {
	int data;
	Node next;
}

public class Solution {
	// This is a "method-only" submission.
	// You only need to complete this method
	Node MergeLists(Node list1, Node list2) {
		Node tempHead = new Node();
		Node tail = tempHead;

		while (list1 != null || list2 != null) {
			Node node;
			if (list2 == null || (list1 != null && list1.data <= list2.data)) {
				node = list1;
				list1 = list1.next;
			} else {
				node = list2;
				list2 = list2.next;
			}
			node.next = null;
			tail.next = node;
			tail = tail.next;
		}

		return tempHead.next;
	}
}
