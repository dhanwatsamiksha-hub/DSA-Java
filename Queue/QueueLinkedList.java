import java.util.*;

public class QueueLinkedList {

    Node front;
    Node rear;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert element
    void enqueue(int value) {

        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(value + " inserted");
    }

    // Delete element
    void dequeue() {

        if (front == null) {
            System.out.println("Queue is Empty");
        }
        else {
            System.out.println(front.data + " deleted");

            front = front.next;

            if (front == null) {
                rear = null;
            }
        }
    }

    // Display elements
    void display() {

        if (front == null) {
            System.out.println("Queue is Empty");
        }
        else {
            Node temp = front;

            System.out.println("Queue elements:");

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QueueLinkedList q = new QueueLinkedList();

        int choice;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.display();
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
