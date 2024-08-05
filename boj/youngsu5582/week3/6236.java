import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 현우는 용돈을 효율적으로 활용하고 돈을 펑펑 쓰지 않기 위해서
// 앞으로 N일 동안 자신이 매일 사용할 금액을 계산하고,
// 정확히 통장에서 M번, K원 씩 출금해서 사용하기로 결정했습니다.
// 현재 수중에 있는 금액으로 하루를 보낼 수 있다면 그대로 소비합니다.
// 부족하다면, 수중에 있는 금액은 통장에 넣은 뒤 K원을 인출해서 하루를 생활합니다.
// 이때, 현우가 매번 출금할 금액 K원의 최솟값을 구하는 프로그램을 작성해주세요.
public class Main {
private static final StringBuilder sb = new StringBuilder();
private static int n;
private static int m;
private static List<Integer> ary = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            ary.add(Integer.parseInt(br.readLine()));
        }
        int max = findMax();
        int left = 0;
        int right = (max * n) / m;
        System.out.println(Math.max(max, findMinK(left, right)));
    }

    private static int findMinK(int left, int right) {
        int mid = (left + right) / 2;
        int money = 0;
        int count = 0;
        if (left > right) {
            return left;
        }
        for (int i = 0; i < ary.size(); i++) {
            if (money < ary.get(i)) {
                count++;
                money = mid;
                if (count == m + 1) {
                    return findMinK(mid + 1, right);
                }
            }
            money -= ary.get(i);
        }
        return findMinK(left, mid - 1);
    }

    private static int findMax() {
        return ary.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}
