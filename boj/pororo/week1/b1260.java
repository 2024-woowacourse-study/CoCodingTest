package boj.pororo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1260 {

    private static StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int V = Integer.parseInt(tokenizer.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] isVisited = new boolean[N + 1];
        dfs(V, graph, isVisited);

        resultBuilder.append(System.lineSeparator());

        isVisited = new boolean[N + 1];
        bfs(V, graph, isVisited);
    }

    private static void dfs(int V, List<List<Integer>> graph, boolean[] isVisited) {
        resultBuilder.append(V).append(" ");
        isVisited[V] = true;

        for (int nx : graph.get(V)) {
            if (!isVisited[nx]) {
                dfs(nx, graph, isVisited);
            }
        }
    }

    private static void bfs(int V, List<List<Integer>> graph, boolean[] isVisited) {
        resultBuilder.append(V).append(" ");
        isVisited[V] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int nx : graph.get(x)) {
                if (!isVisited[nx]) {
                    queue.add(nx);
                    resultBuilder.append(nx).append(" ");
                    isVisited[nx] = true;
                }
            }
        }
    }
}
