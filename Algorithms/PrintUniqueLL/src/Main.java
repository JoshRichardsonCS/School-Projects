import java.util.HashMap;

class Node {
    int value;
    Node next;

    public Node(int data) {
        this.value = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
// print all unique numbers in a linked list
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(5);
        printLinkedList(head);
        findUniqueNumbers(head);
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void findUniqueNumbers(Node head) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        Node cur = head;
        while (cur != null) {
            if(hash.containsKey(cur.value))
            {
                hash.put(cur.value, hash.get(cur.value) + 1);
            }
            else {
                hash.put(cur.value, 1);
            }
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            if (hash.get(cur.value) == 1) {
                System.out.print(cur.value + " ");
            }
            cur = cur.next;
        }
    }
}