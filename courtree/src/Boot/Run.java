package Boot;

import court.court;
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
	court myCourt=new court();
	myCourt.addNodeToTrees(new Node(199102, "matan"));
	myCourt.addNodeToTrees(new Node(199002, "moshmosh"));
	myCourt.addNodeToTrees(new Node(199502, "snir"));
	myCourt.addNodeToTrees(new Node(199502, "no-far"));
	myCourt.addNodeToTrees(new Node(199502, "bar"));
	System.out.println("Seaech for bar node: "+  myCourt.searchByAge(199502));
	System.out.println("Expected president:");
	myCourt.printExpectedPresident();
	
	}
	public static void mainOld(String[] args) {
		BinaryTree ageTree = new BinaryTree(new ageComper());
		BinaryTree seniorityTree = new BinaryTree(new seniorityComper());
		
		addNodeToTrees(ageTree,seniorityTree,new Node(199102, "matan"));
		addNodeToTrees(ageTree,seniorityTree,new Node(199002, "moshmosh"));
		addNodeToTrees(ageTree,seniorityTree,new Node(199502, "snir"));
		addNodeToTrees(ageTree,seniorityTree,new Node(199602, "no-far"));
		addNodeToTrees(ageTree,seniorityTree,new Node(199601, "bar"));


		
		// Different ways to traverse binary trees
		System.out.println("by age:");
		 ageTree.inOrderTraverseTree(ageTree.getRoot());
		 
			System.out.println("\nby seniority:");
			seniorityTree.inOrderTraverseTree(seniorityTree.getRoot());
		 
		 
		 
		 ageTree.remove(199601);
		 
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
