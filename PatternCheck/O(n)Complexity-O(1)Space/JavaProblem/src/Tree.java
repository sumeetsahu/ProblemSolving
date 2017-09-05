
public class Tree {
	
	private Node root;

	
	public Tree(Node root){
		
		this.root = root;

	}
	

	static Node commonRoot = null;
	private int FindCommonRoot(Node node, Node A, Node B) {
		
		if(node==null)
			return 0;
		
		int currentValue = 0;
		
		if(node==A || node==B)
			currentValue = 1;
		
		int leftValue = FindCommonRoot(node.getLeft(), A, B);
		int rightValue = FindCommonRoot(node.getRight(), A, B);
		
		if(	  (currentValue == 1 && leftValue == 1)
			||(currentValue == 1 && rightValue == 1)
			||(leftValue == 1 && rightValue == 1)){
			   
			commonRoot = node;
			return 2;
		}
		
		return currentValue + leftValue + rightValue;	
		
		
		
	}
	
	
	public Node GetCommonNode(Node A, Node B) {

		FindCommonRoot(root, A,B);
		return commonRoot;
	}

}
