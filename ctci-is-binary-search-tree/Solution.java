// Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

// The Node class is defined as follows:
class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {
	boolean checkBST(Node root) {
		    boolean checkBST(Node root) {
        return _checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean _checkBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        // Current node's data must always be between min and max.
        if (node.data < min || node.data > max) {
            return false;
        }

        // Recursively shrink the boundaries for min and max of each node.
        int data = node.data;
        return _checkBST(node.left, min, data - 1) && 
               _checkBST(node.right, data + 1, max);
    }
}
