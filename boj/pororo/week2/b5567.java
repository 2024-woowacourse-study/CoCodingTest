package boj.pororo.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class b5567 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        List<List<Integer>> records = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            records.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            records.get(a).add(b);
            records.get(b).add(a);
        }

        boolean[] isFriend = new boolean[n + 1];
        bfs(1, records, isFriend);

        int result = countFriend(n, isFriend);
        System.out.println(result);
    }

    private static void bfs(int num, List<List<Integer>> records, boolean[] isFriend) {
        isFriend[num] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);

        int connection = 0;
        while (!queue.isEmpty()) {
            if (connection == 2) {
                return;
            }

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int nextX : records.get(x)) {
                    if (!isFriend[nextX]) {
                        isFriend[nextX] = true;
                        queue.offer(nextX);
                    }
                }
            }
            connection++;
        }
    }

    private static int countFriend(int n, boolean[] isFriend) {
        return (int) IntStream.rangeClosed(2, n)
                .filter(x -> isFriend[x])
                .count();
    }
}
