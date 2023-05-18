import java.util.ArrayList;
import java.util.Stack;

/*class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/
public class Inorder_iterative
{
    static  ArrayList<Integer> inorder(Node curr)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while(true)  //infinite loop
        {
            if(curr != null) //checking if curr node is null or not
            {
                stack.push(curr);   //not null value, we push it
                curr = curr.left;   //move the current node to its left child
            }
            else  //pointing to null
            {

                if( !stack.isEmpty()) //checking if the stack is empty or not
                {
                    curr = stack.peek();
                    list.add(curr.data);

                    stack.pop();
                    curr = curr.right;
                }
                //means the stack is empty we have traversed through the tree, here we break
                else
                {
                    break;
                }
            }
        }
        return list;

    }
    public static void main(String args[]) {

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
        list = inorder(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
