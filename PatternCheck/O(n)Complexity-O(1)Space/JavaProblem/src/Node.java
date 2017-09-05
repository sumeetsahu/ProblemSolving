
public class Node implements Comparable {

	private Node left;
	private Node right;
	private int value;
	
	public Node(){
		
	}
	
	public Node(int value){
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int compareTo(Node node) {

		if(this.value<node.value) return -1;
		if(this.value>node.value) return 1;
		return 0;
		
	}
	public int compareTo(Object arg0) {

		return compareTo((Node) arg0);
	}
	
	public String toString(){
		return Integer.toString(value);
	}
	
	
}
