



public class Main {
	
	private static boolean foundY = false;
	
	public static boolean IsInorder(Node root, Node x, Node y, Node z)
	{
		foundY=false;
		
		Tree tree = new Tree(root);
		Node common = tree.GetCommonNode(x, z);
		
		//If no common root then return false
		if(common==null)
			return false;
		
		//If common is Y make sure that it has both child
		if(common==y)
		{
			if(common.getLeft()==null || common.getRight()==null)
				return false;
			return true;
		}
		
		
		Traverse(common.getLeft(),x,y,z);
		Traverse(common.getRight(),x,y,z);
		
		return foundY;
	
	}
	
	
	private static boolean Traverse(Node node, Node x, Node y, Node z) {

		if(node==null)
			return false;
		
		if(node==x || node==z)
			return true;

		if(Traverse(node.getLeft(), x, y, z))
				if(node==y)
					foundY=true;
		
		
		if(Traverse(node.getRight(), x, y, z))
				if(node==y)
					foundY=true;
		
		return false;
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


	private static void Print(boolean isInorder) {

		System.out.println(isInorder);
	}


}
