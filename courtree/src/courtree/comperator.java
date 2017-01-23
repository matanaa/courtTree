package courtree;

public interface comperator {
	public boolean compareTo(Node n1,Node n2);
	public int compareTokey(Node n1,int key);
	public int minValue(Node n1);
	//public int setminValue(Node n1);
	public void setValue(Node n1, int value);
	 public int getKey(Node n1);
}
