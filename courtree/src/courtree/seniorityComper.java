package courtree;

public class seniorityComper implements comperator  {

	public seniorityComper() {
		// TODO Auto-generated constructor stub
	}

	public boolean compareTo(Node n1,Node n2) {
		// TODO Auto-generated method stub
		return n1.getSeniority()<n2.getSeniority();
	}

}
