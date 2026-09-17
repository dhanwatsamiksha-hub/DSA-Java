import java.util.*;

public class FloydWarshall {

    static void floydWarshall(int[][] graph) {

        int n = graph.length;

        int[][] distance = new int[n][n];

        // Copy graph into distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (distance[i][k] != 999 &&
                        distance[k][j] != 999) {

                        distance[i][j] = Math.min(
                            distance[i][j],
                            distance[i][k] + distance[k][j]
                        );
                    }
                }
            }
        }

        System.out.println("\nShortest Distance Matrix:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (distance[i][j] == 999)
                    System.out.print("INF ");
                else
                    System.out.print(distance[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0,   5,  999, 10},
            {999, 0,  3,   999},
            {999, 999, 0,  1},
            {999, 999, 999, 0}
        };

        floydWarshall(graph);
    }
}
