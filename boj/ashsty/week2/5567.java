import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 총 동기의 수
        int m = Integer.parseInt(br.readLine()); // 친구 관계의 수

        // 친구 관계를 저장할 인접 리스트
        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        // BFS를 위한 변수
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int level = 0;

        // 상근이의 친구를 찾기 위한 BFS
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty() && level < 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int friend : friends.get(current)) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.add(friend);
                        count++;
                    }
                }
            }
            level++;
        }

        System.out.println(count);
    }
}
