import java.util.*;

public class DijkstraAlgorithm {

    static void dijkstra(int[][] graph, int start) {

        int n = graph.length;

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // Set all distances to infinity
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;

        for (int count = 0; count < n; count++) {

            int u = -1;

            // Find the unvisited vertex with minimum distance
            for (int i = 0; i < n; i++) {

                if (!visited[i] &&
                    (u == -1 || distance[i] < distance[u])) {
                    u = i;
                }
            }

            visited[u] = true;

            // Update distances
            for (int v = 0; v < n; v++) {

                if (graph[u][v] != 0 &&
                    !visited[v] &&
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + graph[u][v] < distance[v]) {

                    distance[v] =
                        distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nShortest distances from vertex " + start + ":");

        for (int i = 0; i < n; i++) {
            System.out.println(
                start + " -> " + i + " = " + distance[i]
            );
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, 1, 0, 0},
            {4, 0, 2, 5, 0},
            {1, 2, 0, 8, 10},
            {0, 5, 8, 0, 2},
            {0, 0, 10, 2, 0}
        };

        dijkstra(graph, 0);
    }
}
