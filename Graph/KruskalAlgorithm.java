import java.util.*;

public class KruskalAlgorithm {

    // Edge class
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Find parent
    static int find(int[] parent, int vertex) {

        if (parent[vertex] == vertex) {
            return vertex;
        }

        return parent[vertex] = find(parent, parent[vertex]);
    }

    // Union
    static void union(int[] parent, int[] rank,
                      int u, int v) {

        int rootU = find(parent, u);
        int rootV = find(parent, v);

        if (rootU != rootV) {

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            }
            else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            }
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];

        System.out.println("Enter source, destination and weight:");

        for (int i = 0; i < m; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            edges[i] = new Edge(source, destination, weight);
        }

        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a.weight - b.weight);

        int[] parent = new int[n];
        int[] rank = new int[n];

        // Initially every vertex is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int totalCost = 0;
        int edgeCount = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        for (Edge edge : edges) {

            int rootU = find(parent, edge.source);
            int rootV = find(parent, edge.destination);

            // If roots are different, no cycle is formed
            if (rootU != rootV) {

                System.out.println(
                    edge.source + " - " +
                    edge.destination + " : " +
                    edge.weight
                );

                totalCost += edge.weight;
                edgeCount++;

                union(parent, rank,
                      edge.source, edge.destination);

                if (edgeCount == n - 1) {
                    break;
                }
            }
        }

        System.out.println("Total Cost: " + totalCost);

        sc.close();
    }
}
