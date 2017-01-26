package court;

import courtree.BinaryTree;
import courtree.Node;
import courtree.ageComper;
import courtree.seniorityComper;

public class court {
	BinaryTree ageTree;
	BinaryTree seniorityTree ;
	Node president;
	
	public court() {
		 ageTree = new BinaryTree(new ageComper());
		 seniorityTree = new BinaryTree(new seniorityComper());
		 president=null;
	}
	
	public void addNodeToTrees(Node node){
		Node ageNode =node;
		Node seniorityNode =new Node(node);
		seniorityNode.setCmp(new seniorityComper());
		ageNode.setTwin(seniorityNode);
		seniorityNode.setTwin(ageNode);
		ageTree.addNode(ageNode);
		seniorityTree.addNode(seniorityNode);
		if (president==null){
			president=ageNode;
		}
		
	}
	
	public Node searchByAge(int age){
		return ageTree.findNode(age);
	}
	
	public boolean removeByAge(int age){
		return ageTree.remove(age);
	}
	
	public void printExpectedPresident(){
		seniorityTree.setPresident(president);
		seniorityTree.ExpectedPresident(president);
		
	}
	

}
