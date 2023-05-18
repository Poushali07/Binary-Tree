package assignment_1;
import java.util. ArrayList;

/*class Node
{
   	int data;
   	Node left, right;
   	
   	Node(int data)
   	{
   		this.data = data;
   	}
   	
}*/

public class DFS_inorder
{
	static void inorder(Node curr, ArrayList<Integer> list)
	{
		if(curr == null)
			return;
		
		inorder(curr.left, list);
		list.add(curr.data);
		inorder(curr.right, list);
	}
	
	public static void main(String[] args)
	{
		Node root = new Node(1);
		  root.left = new Node(2);
		  root.right = new Node(3);
		  root.left.left = new Node(4);
	      root.left.right = new Node(5);
	      root.left.right.left = new Node(8);
	      root.right.left = new Node(6);
	      root.right.right = new Node(7);
	      root.right.right.left = new Node(9);
	      root.right.right.right = new Node(10);
	      
	      ArrayList<Integer> list = new ArrayList<>();
	      inorder(root, list);  //function call
	  
	      for(int i = 0; i< list.size();i++)
	      {
	    	  System.out.print(list.get(i)+" ");
	      }
	}
}
