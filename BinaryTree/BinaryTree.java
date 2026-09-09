import java.util.*;

public class BinaryTree {

    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Create tree
    Node createTree(Scanner sc) {

        System.out.print("Enter value (-1 for no node): ");
        int value = sc.nextInt();

        if (value == -1) {
            return null;
        }

        Node newNode = new Node(value);

        System.out.println("Enter left child of " + value);
        newNode.left = createTree(sc);

        System.out.println("Enter right child of " + value);
        newNode.right = createTree(sc);

        return newNode;
    }

    // Inorder: Left Root Right
    void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder: Root Left Right
    void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left Right Root
    void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();

        tree.root = tree.createTree(sc);

        System.out.print("\nInorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);

        sc.close();
    }
}
