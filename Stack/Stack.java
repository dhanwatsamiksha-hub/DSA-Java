import java.util.*;

public class Stack {

    static int top = -1;
    static int[] stack = new int[5];

    public static void push(int value) {

        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
        }
        else {
            top++;
            stack[top] = value;
            System.out.println(value + " pushed");
        }
    }

    public static void pop() {

        if (top == -1) {
            System.out.println("Stack Underflow");
        }
        else {
            System.out.println(stack[top] + " popped");
            top--;
        }
    }

    public static void display() {

        if (top == -1) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Stack elements:");

            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                    push(value);
                    break;

                case 2:
                    pop();
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
