package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; //Generic type
		
		public TreeNode(int data) {
			this.data=data;
		}
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
	}
	
	public void preOrderRecursive(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	
	public void preOrderLoop() {
		if(root==null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	
	public void inOrderRecursive(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack();
		TreeNode temp = root;
		
		while(!stack.isEmpty() || temp != null) {
			if(temp!=null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public void postOrderSecond(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack();
		while(current != null || !stack.isEmpty()){
		     if(current != null) {
		    	 stack.push(current);
		    	 current = current.left;	
		     } 
		     else {
		    	 TreeNode temp = stack.peek().right;	        	    
		    	 if(temp == null) {
		    		 temp = stack.pop();
		    		 System.out.print(temp.data + " ");
		             while(!stack.isEmpty() && temp == stack.peek().right) {
		            	 temp = stack.pop();
		            	 System.out.print(temp.data + " "); 
		             }     
		    	 } 
			     else {
			    	   current = temp;
		         }
		     }
		}
	}
	
	public void levelOrder() {
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			if(temp.right != null) {
				queue.offer(temp.right);
			}
		}
	}
	
	public void inOrderLoop() {
		
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
//		binaryTree.preOrderRecursive(binaryTree.root);
		
		binaryTree.preOrderLoop();
		System.out.println();
		binaryTree.inOrderRecursive(binaryTree.root);
		
		System.out.println();
		binaryTree.inOrder(binaryTree.root);
		
		System.out.println();
		binaryTree.postOrder(binaryTree.root);
		
		System.out.println();
		binaryTree.levelOrder();
		
	}
}
