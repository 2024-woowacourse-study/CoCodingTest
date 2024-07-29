import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        final int v = Integer.parseInt(st.nextToken());


        final int[][] ary = new int[n + 1][n + 1];
        final boolean[] visited = new boolean[n + 1];
        final boolean[] visited2 = visited.clone();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());
            ary[x][y] = 1;
            ary[y][x] = 1;
        }
        dfs(visited, ary, v);
        sb.append("\n");
        bfs(visited2, ary, v);
        System.out.println(sb);

    }

    public static void dfs(boolean[] visited, int[][] ary, int pos) {
        visited[pos] = true;
        sb.append(pos)
                .append(" ");
        for (int i = 1; i < ary[pos].length; i++) {
            if (!visited[i] && ary[pos][i] == 1) {
                dfs(visited, ary, i);
            }
        }
    }

    public static void bfs(boolean[] visited, int[][] ary, int pos) {
        Deque<Integer> temp = new ArrayDeque<>();
        temp.add(pos);
        while (!temp.isEmpty()) {
            pos = temp.pollFirst();
            if (visited[pos]) {
                continue;
            }
            visited[pos] = true;
            sb.append(pos)
                    .append(" ");
            for (int i = 1; i < ary[pos].length; i++) {
                if (!visited[i] && ary[pos][i] == 1) {
                    temp.add(i);
                }
            }
        }
    }

}
