import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] list;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        list = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x][y] = 1;
            list[y][x] = 1;
        }
        visited[1] = true;

        dfs(1, 2);
        System.out.println(answer);

    }

    public static void dfs(int x, int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 2; i < list.length; i++) {
            if (list[x][i] == 1) {
                if (!visited[i]) {
                    answer++;
                    visited[i] = true;
                }
                dfs(i, count - 1);
            }
        }
    }
}
