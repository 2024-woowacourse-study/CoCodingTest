import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    private static int[][] ary;
    private static int n;
    private static int count;

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        ary = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ary[x][y] = 1;
            ary[y][x] = 1;
        }

        visited = new boolean[n + 1];
        dfs(1);
        System.out.println(count-1);
    }

    public static void dfs(int pos) {
        visited[pos] = true;
        count++;
        for (int i = 1; i <= n; i++) {
            if(!visited[i] && ary[pos][i]==1) {
                dfs(i);
            }
        }
    }

}
