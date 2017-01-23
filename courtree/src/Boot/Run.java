package Boot;

import courtree.BinaryTree;
import courtree.Node;
import courtree.ageComper;
import courtree.seniorityComper;

public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}

	public static void addNodeToTrees(BinaryTree ageTree,BinaryTree seniorityTree,Node node)
	{
		//Node ageNode =new Node(node);
		Node ageNode =node;
		Node seniorityNode =new Node(node);
		seniorityNode.setCmp(new seniorityComper());
		ageNode.setTwin(seniorityNode);
		seniorityNode.setTwin(ageNode);
		ageTree.addNode(ageNode);
		seniorityTree.addNode(seniorityNode);
	}
	public static void main(String[] args) {
		BinaryTree ageTree = new BinaryTree(new ageComper());
		BinaryTree seniorityTree = new BinaryTree(new seniorityComper());
		
		addNodeToTrees(ageTree,seniorityTree,new Node(199102, "matan",199903));
		addNodeToTrees(ageTree,seniorityTree,new Node(199002, "moshmosh",200003));
		addNodeToTrees(ageTree,seniorityTree,new Node(199502, "snir",200103));
		addNodeToTrees(ageTree,seniorityTree,new Node(199602, "no-far",200104));
		addNodeToTrees(ageTree,seniorityTree,new Node(199601, "bar",200102));


		
		// Different ways to traverse binary trees
		System.out.println("by age:");
		 ageTree.inOrderTraverseTree(ageTree.getRoot());
		 ageTree.remove(199002);
		 
		 System.out.println("\nremove:");
		 ageTree.inOrderTraverseTree(ageTree.getRoot());
		System.out.println("\nby seniority:");
		seniorityTree.inOrderTraverseTree(seniorityTree.getRoot());

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 199602");

		System.out.println(ageTree.findNode(199602));


	}

}
