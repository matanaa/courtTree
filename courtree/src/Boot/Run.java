package Boot;

import courtree.BinaryTree;

public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();

		theTree.addNode(199102, "matan",199903);

		theTree.addNode(199002, "moshmosh",200003);
		
		theTree.addNode(199502, "snir",200103);
		theTree.addNode(199602, "no-far",200104);
		theTree.addNode(199601, "bar",200102);
		// Different ways to traverse binary trees

		 theTree.inOrderTraverseTree(theTree.getRoot());

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 199602");

		System.out.println(theTree.findNode(199602));


	}

}
