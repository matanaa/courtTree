package courtree;
import courtree.*;

public class BinaryTree {

	private Node root; //President
	public static int Counter = 0;
	public static int changekey = 0;
	public comperator cmp; 
	Node president;
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



	public void addNode(int key, String name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (getRoot() == null) {

			setRoot(newNode);

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = getRoot();

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.bDate) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}
	
	
	
	public BinaryTree(comperator cmp) {
		super();
		this.cmp = cmp;
	}
	public BinaryTree() {
		super();
		this.cmp = new ageComper();
		//this.cmp = new seniorityComper();
	}


	
	public Node addNode(Node newNode) {


		// If there is no root this becomes root

		if (getRoot() == null) {
			newNode.setParent(null);
			setRoot(newNode);

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = getRoot();

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (cmp.compareTo(newNode, focusNode)) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						newNode.setParent(parent);
						//return; // All Done
						break;

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						newNode.setParent(parent);
						//return; // All Done
						break;

					}

				}

			}
		}
		
		return newNode;

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth
	
	public Node nextPresident(Node focusNode) {

		if (focusNode != null) {

			// Traverse the right node
			Node val;
			val = nextPresident(focusNode.rightChild);
			if (val !=null){
				return val;
			}

			// Visit the currently focused on node
			if (president.getbDate() <=focusNode.getbDate()){
			return focusNode;
			
			}


			// Traverse the left node

			return nextPresident(focusNode.leftChild);
		}
		return null;

	}
	
	public void ExpectedPresident(Node focusNode) {

		if (focusNode != null) {

			// Traverse the right node

			ExpectedPresident(focusNode.rightChild);

			// Visit the currently focused on node
			if (president.getbDate() <=focusNode.getbDate()){
			System.out.println(focusNode);
			setPresident(focusNode);
			}


			// Traverse the left node

			ExpectedPresident(focusNode.leftChild);
		}

	}



	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = getRoot();
		if (focusNode==null)
			return focusNode;
		// While we haven't found the Node
		// keep looking

		while (focusNode.bDate != key) {

			// If we should search to the left

			if (key < focusNode.bDate) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}


public boolean remove(int Bdate) { 

    if (getRoot() == null) 

          return false; 

    else { 

        	  Node remover=this.findNode(Bdate);
        	  if (remover.getTwin()!= null){
        		  remover.getTwin().remove();
        		  remover.setTwin(null);
        	  }
        		  
        	  return remover.remove(); 

    	} 

	}

}
