import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static int n;
    private static int m;
    private static int[][] ary;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && ary[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int[][] directions = new int[][]{
            //RIGHT LEFT DOWN UP
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void dfs(int x, int y) {
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                if (!visited[newX][newY] && ary[x][y] != 0 && (ary[newX][newY] >= ary[x][y] - 1 || ary[newX][newY] <= ary[x][y] + 1)) {
                    visited[newX][newY] = true;
                    dfs(newX, newY);
                }
            }
        }
    }
}
