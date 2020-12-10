package binaryTree;

import javax.swing.tree.TreeNode;

public class BinaryTree {

	private TreeNode root;
	
	private class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data; //any generic type
		
		private TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void createbinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
	}
	
	public static void main(String[] args) {
		
	}
}
