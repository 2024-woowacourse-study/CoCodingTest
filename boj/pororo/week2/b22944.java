package boj.pororo.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b22944 {

    private static class Data {
        private final int x;
        private final int y;
        private final int strength;
        private final int durability;

        public Data(int x, int y, int strength, int durability) {
            this.x = x;
            this.y = y;
            this.strength = strength;
            this.durability = durability;
        }

        public boolean isDurabilityRemain() {
            return durability > 0;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getStrength() {
            return strength;
        }

        public int getDurability() {
            return durability;
        }
    }

    private static final int[] DIRECTIONS_OF_X = {1, 0, -1, 0};
    private static final int[] DIRECTIONS_OF_Y = {0, 1, 0, -1};

    private static int N;
    private static int durability;
    private static char[][] map;
    private static int[][] check;

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        int strength = Integer.parseInt(tokenizer.nextToken());
        durability = Integer.parseInt(tokenizer.nextToken());

        map = new char[N][N];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = (char) reader.read();
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
            reader.read();
        }

        Data data = new Data(startX, startY, strength, 0);

        check = new int[N][N];
        check[startX][startY] = strength;
        int answer = bfs(data);
        System.out.println(answer);
    }

    private static int bfs(Data data) {
        int movingCount = 0;
        Queue<Data> queue = new LinkedList<>();
        queue.offer(data);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Data tmp = queue.poll();
                int x = tmp.getX();
                int y = tmp.getY();

                for (int j = 0; j < 4; j++) {
                    int nx = x + DIRECTIONS_OF_X[j];
                    int ny = y + DIRECTIONS_OF_Y[j];
                    int d = tmp.getDurability();
                    int s = tmp.getStrength();

                    if (isOutOfRange(nx, ny)) {
                        continue;
                    }

                    char info = map[nx][ny];
                    if (info == 'E') {
                        return movingCount + 1;
                    }
                    if (info == 'U') {
                        d = durability;
                    }
                    if (d > 0) {
                        d--;
                    } else {
                        s--;
                    }
                    if (s == 0) {
                        continue;
                    }

                    if (check[nx][ny] < s + d) {
                        check[nx][ny] = s + d;
                        queue.offer(new Data(nx, ny, s, d));
                    }
                }
            }
            movingCount++;
        }
        return -1;
    }

    private static boolean isOutOfRange(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N;
    }
}
