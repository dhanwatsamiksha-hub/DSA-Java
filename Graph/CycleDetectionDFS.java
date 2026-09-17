import java.util.*;

public class CycleDetectionDFS {

    static boolean dfs(int[][] graph, int node, int parent, boolean[] visited) {

        visited[node] = true;

        for (int i = 0; i < graph.length; i++) {

            if (graph[node][i] == 1) {

                if (!visited[i]) {

                    if (dfs(graph, i, node, visited)) {
                        return true;
                    }
                }
                else if (i != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean hasCycle(int[][] graph) {

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {

                if (dfs(graph, i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {0, 0, 1, 0}
        };

        if (hasCycle(graph))
            System.out.println("Cycle exists");
        else
            System.out.println("No cycle");
    }
}
