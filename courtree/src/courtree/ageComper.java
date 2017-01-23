package courtree;

public class ageComper implements comperator {

	public ageComper() {
		// TODO Auto-generated constructor stub
	}
	public boolean compareTo(Node n1,Node n2) {
		// TODO Auto-generated method stub
		return n1.getbDate() <n2.getbDate() ;
	}

	public int compareTokey(Node n1, int key) {
		return n1.getbDate() -key ;
	}
	
	 public int minValue(Node n1) { 
			
	        if (n1.leftChild == null) 
	        	 return n1.getbDate();
	        else 

	              return this.minValue(n1.getLeft());
	 }
	 
	 public void setValue(Node n1,int value) { 
	 
	 n1.setbDate(value);
	 }
	 
	 public int getKey(Node n1){
		 return n1.getbDate();
	 }


}
