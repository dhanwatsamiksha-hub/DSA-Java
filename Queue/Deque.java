import java.util.*;

public class Deque {

    static int[] deque = new int[5];
    static int front = -1;
    static int rear = -1;

    static void insertFront(int value) {

        if (front == 0) {
            System.out.println("Cannot insert at front");
        }
        else {
            if (front == -1) {
                front = rear = 0;
            }
            else {
                front--;
            }

            deque[front] = value;
            System.out.println(value + " inserted at front");
        }
    }

    static void insertRear(int value) {

        if (rear == deque.length - 1) {
            System.out.println("Queue is Full");
        }
        else {
            if (rear == -1) {
                front = rear = 0;
            }
            else {
                rear++;
            }

            deque[rear] = value;
            System.out.println(value + " inserted at rear");
        }
    }

    static void deleteFront() {

        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty");
        }
        else {
            System.out.println(deque[front] + " deleted from front");
            front++;
        }
    }

    static void deleteRear() {

        if (rear == -1 || front > rear) {
            System.out.println("Queue is Empty");
        }
        else {
            System.out.println(deque[rear] + " deleted from rear");
            rear--;
        }
    }

    static void display() {

        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty");
        }
        else {
            System.out.println("Deque elements:");

            for (int i = front; i <= rear; i++) {
                System.out.print(deque[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    insertFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    insertRear(sc.nextInt());
                    break;

                case 3:
                    deleteFront();
                    break;

                case 4:
                    deleteRear();
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
