import java.util.*;

public class HuffmanCoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    // Generate Huffman codes
    static void generateCode(Node root, String code) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        generateCode(root.left, code + "0");
        generateCode(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.freq - b.freq);

        System.out.println("Enter character and frequency:");

        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node first = pq.poll();
            Node second = pq.poll();

            Node newNode =
                    new Node(first.freq + second.freq, first, second);

            pq.add(newNode);
        }

        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");
        generateCode(root, "");

        sc.close();
    }
}
