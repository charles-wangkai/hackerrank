import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int time;
	static long minAddition;

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < q; tc++) {
			int n = Integer.parseInt(br.readLine());
			GraphNode[] graphNodes = new GraphNode[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < graphNodes.length; i++) {
				int value = Integer.parseInt(st.nextToken());

				graphNodes[i] = new GraphNode(value);
			}
			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int graphNodeIndex1 = Integer.parseInt(st.nextToken()) - 1;
				int graphNodeIndex2 = Integer.parseInt(st.nextToken()) - 1;

				graphNodes[graphNodeIndex1].adjacents.add(graphNodeIndex2);
				graphNodes[graphNodeIndex2].adjacents.add(graphNodeIndex1);
			}

			System.out.println(solve(graphNodes));
		}
	}

	static long solve(GraphNode[] graphNodes) {
		if (graphNodes.length < 3) {
			return -1;
		}

		int graphRootNodeIndex = findGraphRootNodeIndexWithMinHeight(graphNodes);
		TreeNode treeRoot = buildTree(graphNodes, graphRootNodeIndex);

		Map<Long, NavigableSet<Integer>> valueSumToEnterTimes = new HashMap<>();
		Map<Long, NavigableSet<Integer>> valueSumToLeaveTimes = new HashMap<>();
		computeSubtreeValueSums(treeRoot, valueSumToEnterTimes, valueSumToLeaveTimes);

		minAddition = Long.MAX_VALUE;
		cut(treeRoot.valueSum, valueSumToEnterTimes, valueSumToLeaveTimes, treeRoot);
		return minAddition == Long.MAX_VALUE ? -1 : minAddition;
	}

	static boolean otherContains(Map<Long, NavigableSet<Integer>> valueSumToEnterTimes,
			Map<Long, NavigableSet<Integer>> valueSumToLeaveTimes, TreeNode treeNode, long targetValueSum) {
		if (valueSumToLeaveTimes.containsKey(targetValueSum)
				&& valueSumToLeaveTimes.get(targetValueSum).lower(treeNode.enterTime) != null) {
			return true;
		}
		if (valueSumToEnterTimes.containsKey(targetValueSum)
				&& valueSumToEnterTimes.get(targetValueSum).higher(treeNode.leaveTime) != null) {
			return true;
		}

		for (TreeNode p = treeNode.parent; p != null; p = p.parent) {
			if (p.valueSum - treeNode.valueSum == targetValueSum) {
				return true;
			}
		}

		return false;
	}

	static void cut(long originalTotal, Map<Long, NavigableSet<Integer>> valueSumToEnterTimes,
			Map<Long, NavigableSet<Integer>> valueSumToLeaveTimes, TreeNode treeNode) {
		long cutValueSum = treeNode.valueSum;
		long remainTotal = originalTotal - cutValueSum;
		if (cutValueSum <= remainTotal) {
			if (cutValueSum == remainTotal) {
				minAddition = Math.min(minAddition, cutValueSum);
			} else {
				if (remainTotal % 2 == 0) {
					long halfRemainTotal = remainTotal / 2;
					if (halfRemainTotal >= cutValueSum
							&& otherContains(valueSumToEnterTimes, valueSumToLeaveTimes, treeNode, halfRemainTotal)) {
						minAddition = Math.min(minAddition, halfRemainTotal - cutValueSum);
					}
				}

				long otherValueSum = remainTotal - cutValueSum;
				if (cutValueSum >= otherValueSum && (otherContains(valueSumToEnterTimes, valueSumToLeaveTimes, treeNode,
						cutValueSum)
						|| otherContains(valueSumToEnterTimes, valueSumToLeaveTimes, treeNode, otherValueSum))) {
					minAddition = Math.min(minAddition, cutValueSum - otherValueSum);
				}
			}
		}

		for (TreeNode child : treeNode.children) {
			cut(originalTotal, valueSumToEnterTimes, valueSumToLeaveTimes, child);
		}
	}

	static void computeSubtreeValueSums(TreeNode treeNode, Map<Long, NavigableSet<Integer>> valueSumToEnterTimes,
			Map<Long, NavigableSet<Integer>> valueSumToLeaveTimes) {
		treeNode.valueSum = treeNode.value;
		for (TreeNode child : treeNode.children) {
			computeSubtreeValueSums(child, valueSumToEnterTimes, valueSumToLeaveTimes);
			treeNode.valueSum += child.valueSum;
		}

		addToValueSumToTimes(valueSumToEnterTimes, treeNode.valueSum, treeNode.enterTime);
		addToValueSumToTimes(valueSumToLeaveTimes, treeNode.valueSum, treeNode.leaveTime);
	}

	static void addToValueSumToTimes(Map<Long, NavigableSet<Integer>> valueSumToTimes, long valueSum, int time) {
		if (!valueSumToTimes.containsKey(valueSum)) {
			valueSumToTimes.put(valueSum, new TreeSet<>());
		}

		valueSumToTimes.get(valueSum).add(time);
	}

	static TreeNode buildTree(GraphNode[] graphNodes, int graphRootNodeIndex) {
		time = 0;
		return buildTreeNode(graphNodes, graphRootNodeIndex, new boolean[graphNodes.length], null);
	}

	static TreeNode buildTreeNode(GraphNode[] graphNodes, int graphNodeIndex, boolean[] visited, TreeNode parent) {
		visited[graphNodeIndex] = true;

		TreeNode treeNode = new TreeNode(graphNodes[graphNodeIndex].value, parent);

		time++;
		treeNode.enterTime = time;

		for (int adjacent : graphNodes[graphNodeIndex].adjacents) {
			if (!visited[adjacent]) {
				treeNode.children.add(buildTreeNode(graphNodes, adjacent, visited, treeNode));
			}
		}

		time++;
		treeNode.leaveTime = time;

		return treeNode;
	}

	static int findGraphRootNodeIndexWithMinHeight(GraphNode[] graphNodes) {
		boolean[] visited = new boolean[graphNodes.length];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < graphNodes.length; i++) {
			if (graphNodes[i].adjacents.size() == 1) {
				visited[i] = true;
				queue.offer(i);
			}
		}

		int rootGraphIndex = -1;
		while (!queue.isEmpty()) {
			int head = queue.poll();
			rootGraphIndex = head;

			for (int adjacent : graphNodes[head].adjacents) {
				if (!visited[adjacent]) {
					visited[adjacent] = true;
					queue.offer(adjacent);
				}
			}
		}
		return rootGraphIndex;
	}
}

class GraphNode {
	int value;
	List<Integer> adjacents = new ArrayList<>();

	GraphNode(int value) {
		this.value = value;
	}
}

class TreeNode {
	int value;
	TreeNode parent;
	List<TreeNode> children = new ArrayList<>();
	int enterTime;
	int leaveTime;
	long valueSum;

	TreeNode(int value, TreeNode parent) {
		this.value = value;
		this.parent = parent;
	}
}