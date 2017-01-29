package court;

import courtree.BinaryTree;
import courtree.Node;
import courtree.ageComper;
import courtree.seniorityComper;

public class court {
	BinaryTree ageTree;
	public BinaryTree seniorityTree ;
	public Node president;
	
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
			president=seniorityNode;
		}
		
	}
	
	public Node searchByAge(int age){
		return ageTree.findNode(age);
	}
	
	public boolean removeByAge(int age){
		Node s =searchByAge(age);
		if (president==s.getTwin())
		{
			seniorityTree.setPresident(president);
			setPresident(seniorityTree.nextPresident(president));
		}
		return ageTree.remove(age);
	}
	
	public void printExpectedPresident(){
		seniorityTree.setPresident(president);
		seniorityTree.ExpectedPresident(president);
		
	}

	/**
	 * @return the president
	 */
	public Node getPresident() {
		return president;
	}

	/**
	 * @param president the president to set
	 */
	public void setPresident(Node president) {
		this.president = president;
	}
	
	
	
	

}
