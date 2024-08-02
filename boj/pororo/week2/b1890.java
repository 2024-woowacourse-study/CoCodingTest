package boj.pororo.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1890 {

    private static final int[] DIRECTION_OF_X = {1, 0};
    private static final int[] DIRECTION_OF_Y = {0, 1};
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        boolean[][] isMoved = new boolean[N + 1][N + 1];
        isMoved[1][1] = true;
        long[][] canMoveToLast = new long[N + 1][N + 1];
        dfs(1, 1, N, board, isMoved, canMoveToLast);

        System.out.println(canMoveToLast[1][1]);
    }

    private static void dfs(int x, int y, int n, int[][] board, boolean[][] isMoved, long[][] canMoveToLast) {
        int jump = board[x][y];
        for (int i = 0; i < 2; i++) {
            int nx = x + (DIRECTION_OF_X[i] * jump);
            int ny = y + (DIRECTION_OF_Y[i] * jump);
            if (isOutOfRange(nx, ny, n)) {
                continue;
            }
            if (canMoveToLast[nx][ny] >= 1) {
                canMoveToLast[x][y] += canMoveToLast[nx][ny];
                continue;
            }
            if (nx == n && ny == n) {
                canMoveToLast[x][y]++;
                continue;
            }
            if (!isMoved[nx][ny]) {
                isMoved[nx][ny] = true;
                dfs(nx, ny, n, board, isMoved, canMoveToLast);
                canMoveToLast[x][y] += canMoveToLast[nx][ny];
                isMoved[nx][ny] = false;
            }
        }
    }

    private static boolean isOutOfRange(int nx, int ny, int n) {
        return nx < 1 || nx > n || ny < 1 || ny > n;
    }
}
