import java.util.*;

public class SinglyLinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            data = data;
            next = null;
        }
    }

    // Insert at beginning
    void insertBeginning(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertEnd(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Delete from beginning
    void deleteBeginning() {

        if (head == null) {
            System.out.println("List is Empty");
        }
        else {
            head = head.next;
        }
    }

    // Display
    void display() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);

        System.out.println("Linked List:");
        list.display();

        list.insertBeginning(5);

        System.out.println("After inserting at beginning:");
        list.display();

        list.deleteBeginning();

        System.out.println("After deleting from beginning:");
        list.display();

        sc.close();
    }
}
