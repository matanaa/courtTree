package courtree;

public class Node {





	int id;
	int bDate;
	String name;
	int seniority;
	

	Node leftChild;
	Node rightChild;
	Node parent;
	Node Twin ;
	comperator cmp;

	/**
	 * @param cmp the cmp to set
	 */
	public void setCmp(comperator cmp) {
		this.cmp = cmp;
	}
	Node(int key, String name) {

		this.bDate = key;
		this.name = name;
		id =BinaryTree.Counter++;

	}
	public Node(int key, String name ,int seniority,comperator cmp) {

		this.bDate = key;
		this.name = name;
		this.seniority=seniority;
		id =BinaryTree.Counter++;
		this.cmp =cmp;

	}
	public Node(int key, String name ,int seniority) {

		this.bDate = key;
		this.name = name;
		this.seniority=seniority;
		id =BinaryTree.Counter++;
		this.cmp =new ageComper();

	}
	
	public Node(Node cp) {

		this.bDate = cp.bDate;
		this.name = cp.name;
		this.seniority=cp.seniority;
		this.Twin = cp.Twin;
		this.cmp =cp.cmp;
		id =BinaryTree.Counter++;

	}
	

	public String toString() {

		return "id:" + id +" name: "+name + " born at  " + bDate+ " seniority " + seniority;

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
/*
        if (cmp.compareTokey(this, key)>0) { // key < this.bDate

              if (leftChild != null) 

                    return leftChild.remove(key, this); 

              else 

                    return false; 

        } else if (cmp.compareTokey(this, key)<0) { // key > this.bDate

              if (rightChild != null) 

                    return rightChild.remove(key, this); 

              else 

                    return false; 

        } else { */
        	
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
