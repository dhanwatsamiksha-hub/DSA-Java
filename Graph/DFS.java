import java.util.*;

public class DFS {

    static void dfs(int[][] graph, int node, boolean[] visited) {

        visited[node] = true;

        System.out.print(node + " ");

        for (int i = 0; i < graph.length; i++) {

            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 1, 0}
        };

        boolean[] visited = new boolean[graph.length];

        System.out.print("DFS Traversal: ");

        dfs(graph, 0, visited);
    }
}
