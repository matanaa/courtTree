package courtree;

public class Node {





	int id;
	int bDate;
	String name;
	
	

	Node leftChild;
	Node rightChild;
	Node parent;
	Node Twin ;
	comperator cmp;

	public void copy(Node from){
		this.id= from.id;
		this.bDate=from.bDate;
		this.name=from.name;
		//this.leftChild = from.leftChild;
		//this.rightChild=from.rightChild;
		this.parent=from.parent;
		this.Twin=from.Twin;
		this.cmp=from.cmp;
				
	}
	/**
	 * @param cmp the cmp to set
	 */
	public void setCmp(comperator cmp) {
		this.cmp = cmp;
	}
	public Node(int key, String name) {

		this.bDate = key;
		this.name = name;
		id =++BinaryTree.Counter;



	}
	public Node(int key, String name ,comperator cmp) {

		this.bDate = key;
		this.name = name;
		id =BinaryTree.Counter++;
		this.cmp =cmp;

	}

	public Node(Node cp) {

		this.bDate = cp.bDate;
		this.name = cp.name;
		this.Twin = cp.Twin;
		this.cmp =cp.cmp;
		id =BinaryTree.Counter;

	}
	

	public String toString() {

		return "id:" + id +" name: "+name + " born at  " + bDate;

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

	
	public boolean remove() { 

		if (parent ==null )//shit im the root
		{
			Node replacement;
			if (leftChild != null && rightChild != null) { 
				replacement = this.leftChild;
				while (replacement.rightChild != null){
					replacement = replacement.rightChild;
				}
			}
			else if (leftChild != null){
				replacement = this.leftChild;
			}
			else if(rightChild != null){
				replacement = this.rightChild;
			}
			else {
				
				return false;
			}
			this.copy(replacement);
				
				
				return replacement.remove();
					
			
		}
        	
              if (leftChild != null && rightChild != null) { 

                    //this.bDate = rightChild.minValue(); 
            	  cmp.setValue(this,cmp.minValue(rightChild));
                    //rightChild.remove(this.bDate, this); 
            	  rightChild.remove(); 

              } else if (parent.leftChild == this) { 

                    parent.leftChild = (leftChild != null) ? leftChild : rightChild; 

              } else if (parent!= null && parent.rightChild == this) { 

                    parent.rightChild = (leftChild != null) ? leftChild : rightChild; 

              } 
              return true; 

        } 

  //}



	
	
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
	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}




}
