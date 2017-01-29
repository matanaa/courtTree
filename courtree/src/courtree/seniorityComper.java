package courtree;

public class seniorityComper implements comperator  {

	public seniorityComper() {
		// TODO Auto-generated constructor stub
	}

	public boolean compareTo(Node n1,Node n2) {
		// TODO Auto-generated method stub
		return n1.getId()>n2.getId();
	}
	
	public int compareTokey(Node n1,int key) {
		// TODO Auto-generated method stub
		return n1.getId()-key;
	}
	
	 public int minValue(Node n1) { 
		
	        if (n1.leftChild == null) 
	        	 return n1.getId();
	        else 

	              return this.minValue(n1.getLeft());
	 }
	 
	 public void setValue(Node n1,int value) { 
	 
	 n1.setId(value);
	 }
	 
	 public int getKey(Node n1){
		 return n1.getId();
	 }

}
