import java.util.*;

public class StackLinkedList {

    Node top;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void push(int value) {

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed");
    }

    void pop() {

        if (top == null) {
            System.out.println("Stack Underflow");
        }
        else {
            System.out.println(top.data + " popped");
            top = top.next;
        }
    }

    void display() {

        if (top == null) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Stack elements:");

            Node temp = top;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StackLinkedList s = new StackLinkedList();

        int choice;

        do {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.display();
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
