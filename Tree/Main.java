package Tree;


public class Main {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(11);
		
		root.getChildren().add(node2);
		root.getChildren().add(node3);
		root.getChildren().add(node4);
		
		node2.getChildren().add(new TreeNode(6));
		
		Tree tree = new Tree();
		tree.breadthFirstSearch(root);
		
		System.out.println("DFS");
		tree.depthFirstSearch(root);
		
	}
}
