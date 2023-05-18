import java.util.*;

/*class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/
public class Preorder_iterative {

    static ArrayList<Integer> preorder(Node curr) {

        ArrayList<Integer> list = new ArrayList<>();
        if (curr == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.push(curr); // what is the root we push it

        while (!stack.isEmpty()) {

            // whatever is in the stack we pop it
            Node top = stack.peek();
            list.add(top.data); // adding it to the arraylist
            stack.pop();

            // traversing right as stack is LIFO
            if (top.right != null) {
                stack.push(top.right);
            }

            // Now traversing left, so that left node will be on the top
            if (top.left != null) {
                stack.push(top.left);
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
        list = preorder(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

}
