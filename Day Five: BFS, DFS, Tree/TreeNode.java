package Tree;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
	private int value;
	private ArrayList<TreeNode> children;
	
	public TreeNode(int value) {
		this.value = value;
		this.children = new ArrayList<>();
	}
	
	public boolean isLeaf() {
		return this.children.isEmpty();
	}
}
