import java.util.*;

public class CircularQueue {

    static int[] queue = new int[5];
    static int front = -1;
    static int rear = -1;

    static void enqueue(int value) {

        if ((rear + 1) % queue.length == front) {
            System.out.println("Queue is Full");
        }
        else {

            if (front == -1) {
                front = 0;
                rear = 0;
            }
            else {
                rear = (rear + 1) % queue.length;
            }

            queue[rear] = value;
            System.out.println(value + " inserted");
        }
    }

    static void dequeue() {

        if (front == -1) {
            System.out.println("Queue is Empty");
        }
        else {

            System.out.println(queue[front] + " deleted");

            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % queue.length;
            }
        }
    }

    static void display() {

        if (front == -1) {
            System.out.println("Queue is Empty");
        }
        else {

            System.out.println("Queue elements:");

            int i = front;

            while (true) {

                System.out.print(queue[i] + " ");

                if (i == rear)
                    break;

                i = (i + 1) % queue.length;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
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
