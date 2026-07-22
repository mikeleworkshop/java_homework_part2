package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public TreeNode root;
	
	public void depthFirstSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.println(root.getValue() + " ");
		
		for (TreeNode child : root.getChildren()) {
			depthFirstSearch(child);
		}
	}
	
	public void breadthFirstSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.println(currentNode.getValue() + " ");
			for (TreeNode child : currentNode.getChildren()) {
				if (child != null) {
					queue.add(child);
				}
			}
		}
		
		System.out.println();
		
	}
}
