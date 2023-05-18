import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class Postorder_iterative_1S
{
    static  ArrayList<Integer> postorder(Node curr)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(curr == null)
            return list;

        Stack<Node> s1 = new Stack<>();
        while(curr != null || s1.isEmpty())
        {
            if(curr != null)
            {
                s1.push(curr);
                curr = curr.left;
            }
            else
            {
                Node temp = s1.peek().right; //peeking the right element from the stack
                if(temp == null) {
                    temp = s1.peek();
                    s1.pop();
                    list.add(temp.data);
                    while (!s1.isEmpty() && temp == s1.peek().right) {
                        temp = s1.peek();
                        s1.pop();
                        list.add(temp.data);
                    }
                }
                else{
                    curr = temp;
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
        list = postorder(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
