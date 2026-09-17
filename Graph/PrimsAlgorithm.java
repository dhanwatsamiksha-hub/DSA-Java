import java.util.*;

public class PrimsAlgorithm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];

        int[] min = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            min[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        min[0] = 0;

        int totalCost = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        for (int count = 0; count < n; count++) {

            int u = -1;

            // Find minimum edge
            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (u == -1 || min[i] < min[u])) {
                    u = i;
                }
            }

            visited[u] = true;

            if (parent[u] != -1) {
                System.out.println(
                    parent[u] + " - " + u + " : " + min[u]
                );

                totalCost += min[u];
            }

            // Update adjacent vertices
            for (int v = 0; v < n; v++) {

                if (graph[u][v] != 0 &&
                    !visited[v] &&
                    graph[u][v] < min[v]) {

                    min[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Total Cost: " + totalCost);

        sc.close();
    }
}
