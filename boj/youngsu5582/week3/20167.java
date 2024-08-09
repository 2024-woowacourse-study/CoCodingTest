import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
private static final StringBuilder sb = new StringBuilder();
private static int n;
private static int k;
private static int[] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ary = new int[n];
        int count = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            ary[count++] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        int prev = 0;
        int result = 0;
        while (count < ary.length) {
            prev += ary[count++];
            if (prev >= k) {
                int next_count = count - 1;
                int next_prev = ary[next_count++];
                while (next_count != ary.length && next_prev < k) {
                    next_prev += ary[next_count++];
                }
                if (next_prev > prev) {
                    count = next_count + 1;
                    result += next_prev - k;
                } else {
                    result += prev - k;
                }
                prev = 0;
            }
        }
        if (prev >= k) {
            result += prev - k;
        }
        System.out.println(result);
    }
}
