import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static int caseNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> dq = new ArrayDeque<>();
        String line = "";
        while (true) {
            line = br.readLine();
            if (line.indexOf("-") != -1) {
                break;
            }
            caseNumber++;
            execute(line);
        }
    }

    private static void execute(String line) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (Character c : line.toCharArray()) {
            if (c.equals('{')) {
                dq.addLast(1);
            } else if (c.equals('}')) {
                if (!dq.isEmpty() && dq.peekLast() == 1) {
                    dq.pollLast();
                } else {
                    dq.addLast(2);
                }
            }
        }
        int count = calculate(dq);
        System.out.println(String.format("%d. %d", caseNumber, count));
    }

    private static int calculate(Deque<Integer> dq) {
        int count = 0;
        while (!dq.isEmpty()) {
            int c1 = dq.pollFirst();
            int c2 = dq.pollFirst();
            if (c1 == 2 && c2 == 1) {
                count += 2;
            } else {
                count += 1;
            }
        }
        return count;
    }
}
