package boj.pororo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class b2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> records = new ArrayList<>();
        int computerSize = Integer.parseInt(reader.readLine());
        int connectionInfo = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= computerSize; i++) {
            records.add(new ArrayList<>());
        }

        for (int i = 0; i < connectionInfo; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            records.get(a).add(b);
            records.get(b).add(a);
        }

        boolean[] isConnected = new boolean[computerSize + 1];
        dfs(1, records, isConnected);

        int result = countBirusComputers(computerSize, isConnected);
        System.out.println(result - 1);
    }

    private static void dfs(int startPoint, List<List<Integer>> records, boolean[] isConnected) {
        isConnected[startPoint] = true;

        for (int nextPoint : records.get(startPoint)) {
            if (!isConnected[nextPoint]) {
                dfs(nextPoint, records, isConnected);
            }
        }
    }

    private static int countBirusComputers(int computerSize, boolean[] isConnected) {
        return (int) IntStream.rangeClosed(1, computerSize)
                .filter(point -> isConnected[point])
                .count();
    }
}
