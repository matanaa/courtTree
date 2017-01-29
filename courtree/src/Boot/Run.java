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

	
	
	public static void main(String[] args) {
	court myCourt=new court();
	System.out.println("adding judges!");
	myCourt.addNodeToTrees(new Node(199102, "matan"));
	myCourt.addNodeToTrees(new Node(199002, "moshmosh"));
	myCourt.addNodeToTrees(new Node(199502, "snir"));
	myCourt.addNodeToTrees(new Node(199602, "no-far"));
	myCourt.addNodeToTrees(new Node(199601, "bar"));
	
	System.out.println("Expected president:");
	myCourt.printExpectedPresident();
	
	System.out.println("removing matan (the king) ");
	myCourt.removeByAge(199102);
	
	System.out.println("Expected president(without matan):");
	myCourt.printExpectedPresident();
	
	System.out.println("Seaech for bar node: "+  myCourt.searchByAge(199601));

	
	}
	
	
	
}
