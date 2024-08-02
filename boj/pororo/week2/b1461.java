package boj.pororo.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int position = Integer.parseInt(tokenizer.nextToken());
            if (position >= 0) {
                plus.offer(position);
                continue;
            }
            minus.offer(Math.abs(position));
        }

        int maxPosition = 0;
        if (plus.isEmpty()) {
            maxPosition = minus.peek();
        }
        else if (minus.isEmpty()) {
            maxPosition = plus.peek();
        }
        else {
            maxPosition = Math.max(plus.peek(), minus.peek());
        }

        int moveCount = 0;
        while (!plus.isEmpty()) {
            moveCount += (plus.peek() * 2);

            for (int i = 0; i < m; i++) {
                plus.poll();
            }
        }
        while (!minus.isEmpty()) {
            moveCount += (minus.peek() * 2);

            for (int i = 0; i < m; i++) {
                minus.poll();
            }
        }

        System.out.println(moveCount - maxPosition);
    }
}
