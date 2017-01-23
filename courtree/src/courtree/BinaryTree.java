package courtree;

public class BinaryTree {

	Node root; //presedent
	public static int Counter = 0;

	public void addNode(int key, String name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

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

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

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

    if (root == null) 

          return false; 

    else { 

          if (root.getbDate() == Bdate) { 

        	  Node auxRoot = new Node(0,"0"); 

                auxRoot.setLeft(root); 

                boolean result = root.remove(Bdate, auxRoot); 

                root = auxRoot.getLeft(); 

                return result; 

          } else { 

                return root.remove(Bdate, null); 

          } 

    } 

}


public static void main(String[] args) {

	BinaryTree theTree = new BinaryTree();

	theTree.addNode(50, "Boss");

	theTree.addNode(25, "Vice President");

	theTree.addNode(15, "Office Manager");

	theTree.addNode(30, "Secretary");

	theTree.addNode(75, "Sales Manager");

	theTree.addNode(85, "Salesman 1");

	// Different ways to traverse binary trees

	 theTree.inOrderTraverseTree(theTree.root);

	// theTree.preorderTraverseTree(theTree.root);

	// theTree.postOrderTraverseTree(theTree.root);

	// Find the node with key 75

	System.out.println("\nNode with the key 75");

	System.out.println(theTree.findNode(75));

}
}

class Node {



	int id;
	int bDate;
	String name;
	int seniority;
	

	Node leftChild;
	Node rightChild;
	Node Twin ;

	Node(int key, String name) {

		this.bDate = key;
		this.name = name;
		id =BinaryTree.Counter++;

	}
	

	public String toString() {

		return name + " has the key " + bDate;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}
	
    public int minValue() { 

        if (leftChild == null) 

              return bDate; 

        else 

              return leftChild.minValue(); 

  }

	
	public boolean remove(int bDate, Node parent) { 

        if (bDate < this.bDate) { 

              if (leftChild != null) 

                    return leftChild.remove(bDate, this); 

              else 

                    return false; 

        } else if (bDate > this.bDate) { 

              if (rightChild != null) 

                    return rightChild.remove(bDate, this); 

              else 

                    return false; 

        } else { 

              if (leftChild != null && rightChild != null) { 

                    this.bDate = rightChild.minValue(); 

                    rightChild.remove(this.bDate, this); 

              } else if (parent.leftChild == this) { 

                    parent.leftChild = (leftChild != null) ? leftChild : rightChild; 

              } else if (parent.rightChild == this) { 

                    parent.rightChild = (leftChild != null) ? leftChild : rightChild; 

              } 

              return true; 

        } 

  }



	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the bDate
	 */
	public int getbDate() {
		return bDate;
	}


	/**
	 * @param bDate the bDate to set
	 */
	public void setbDate(int bDate) {
		this.bDate = bDate;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the seniority
	 */
	public int getSeniority() {
		return seniority;
	}


	/**
	 * @param seniority the seniority to set
	 */
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}


	/**
	 * @return the leftChild
	 */
	public Node getLeft() {
		return leftChild;
	}


	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeft(Node leftChild) {
		this.leftChild = leftChild;
	}


	/**
	 * @return the rightChild
	 */
	public Node getRight() {
		return rightChild;
	}


	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRigh(Node rightChild) {
		this.rightChild = rightChild;
	}


	/**
	 * @return the twin
	 */
	public Node getTwin() {
		return Twin;
	}


	/**
	 * @param twin the twin to set
	 */
	public void setTwin(Node twin) {
		Twin = twin;
	}


}