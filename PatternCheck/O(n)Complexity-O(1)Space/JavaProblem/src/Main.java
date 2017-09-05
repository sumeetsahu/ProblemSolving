



public class Main {
	
	private static Node commonRoot = null;
	private static boolean isYonPathOfCommonRoot = false;
	
	private static boolean IsInorder(Node node, Node x, Node y, Node z) {

		isYonPathOfCommonRoot=false;
		
		FindCommonRoot(node, x, z, y);
		
		return isYonPathOfCommonRoot && (commonRoot!=null); // Y should be on path of common root to X and Z with a valid common root
	}

	
	
	private static int FindCommonRoot(Node node, Node A, Node B, Node Y) {
		
		if(node==null)
			return 0;
		
		int currentValue = 0;
		
		if(node==A || node==B)
			currentValue = 1;
		
		int leftValue = FindCommonRoot(node.getLeft(), A, B, Y);
		int rightValue = FindCommonRoot(node.getRight(), A, B, Y);
		
		if(leftValue == 1 || rightValue ==1) //Checking if Y is on the path of common root
		{
			if(node == Y)
			{
				isYonPathOfCommonRoot=true;
			}
		}
		
		// Common root is a node where : one the following is true
		if(	  (currentValue == 1 && leftValue == 1) // 1. current node is one of the node and another node is found in left sub tree 
			||(currentValue == 1 && rightValue == 1) //2. current node is one of the node and another node is found in right sub tree
			||(leftValue == 1 && rightValue == 1)){ //3. exactly one node is found on left sub tree and one node is found on right sub tree
			   
			commonRoot = node;
			return 2; // common root is the first node that found both the node
		}
		
		return currentValue + leftValue + rightValue;	// Return total node found
		
		
		
	}

  
	private static void Print(boolean isInorder) {

		System.out.println(isInorder);
	}


	public static void main( String[] args ) {
		  

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        
        a.setLeft(b); a.setRight(c);
        
        b.setLeft(d);b.setRight(e);
        
        c.setLeft(f);c.setRight(g);
        
        e.setRight(h);
        
        
        
        System.out.println( "Following should be true");
        
        Print(IsInorder(a,b,e,h));// X is common
        Print(IsInorder(a,d,b,e));//True - No need to go parent | pattern xyz
        Print(IsInorder(a,e,b,d));//True - No need to go parent | pattern zyx
        Print(IsInorder(a,d,b,g));//True - need to go parent | pattern xyz
        Print(IsInorder(a,g,b,d));//True - need to go parent | pattern zyx
        Print(IsInorder(a,a,c,g));// X is common
        Print(IsInorder(a,b,a,c));// Y is common
        Print(IsInorder(a,g,c,a));// Z is common
        
     
        

        System.out.println( "Following should be false");
        
        Print(IsInorder(a,d,e,b));//No need to go parent | pattern xzy
        Print(IsInorder(a,e,d,b));//No need to go parent | pattern zxy
        Print(IsInorder(a,b,d,e));//No need to go parent | pattern yxz
        Print(IsInorder(a,b,e,d));//No need to go parent | pattern yzx
        Print(IsInorder(a,d,g,b));//need to go parent | pattern xzy
        Print(IsInorder(a,g,d,b));//need to go parent | pattern zxy
        Print(IsInorder(a,b,d,g));//need to go parent | pattern yxz
        Print(IsInorder(a,b,g,d));//need to go parent | pattern yzx
        Print(IsInorder(a,a,g,c));// X is common
        Print(IsInorder(a,c,a,g));// Y is common
        Print(IsInorder(a,g,a,c));// Z is common
        
        Print(IsInorder(a,d,e,i));// Z doesnt exist
        Print(IsInorder(a,d,i,b));// Y doesnt exist
        Print(IsInorder(a,i,e,b));// X doesnt exist
      
        
        
        System.exit( 0 ); //success
    }




}
