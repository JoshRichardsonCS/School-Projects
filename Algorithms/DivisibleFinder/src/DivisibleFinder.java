import java.util.LinkedList;
import java.util.Queue;

public class DivisibleFinder{
    public static void main(String[] args) {
        // Create a tree of depth 3 with values between 1 and 14
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        // Stub method calls
        System.out.println("Sum of nodes divisible by 3 (Recursive): " + findDivBy3(root));
        System.out.println("Sum of nodes divisible by 3 (Non-Recursive): " + findDivBy3NonRecur(root));
    }

    // Recursive method stub to find nodes divisible by 3
    public static int findDivBy3(Node n) {
        int sum = 0;
        if (n == null) {
            return 0;
        }

        if (n.value % 3 == 0) {
            sum += (n.value);
        }

        sum += findDivBy3(n.left);
        sum += findDivBy3(n.right);

        return sum;
    }

    // Non-recursive method stub to find nodes divisible by 3
    public static int findDivBy3NonRecur(Node n) {
        if (n == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        int sum = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur.value % 3 == 0) {
                sum += cur.value;
            }

            if(cur.left != null) {
                queue.add(cur.left);
            }

            if(cur.right != null) {
                queue.add(cur.right);
            }
        }

        return sum;
    }
}
