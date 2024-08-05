import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Field[][] list;
    private static int n;
    private static int h;
    private static int d;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] visited;

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        h = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());

        list = new Field[n][n];
        visited = new int[n][n];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = Field.from(line.charAt(j));
                if (list[i][j] == Field.START) {
                    startX = i;
                    startY = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        Player player = Player.from(h);
        player.move(startX, startY);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static class Player {
        private int hp;
        private int umbrella;
        private int count;
        private Map<Integer, Boolean> used;

        public Player(int hp, int count, int umbrella, final Map<Integer, Boolean> used) {
            this.hp = hp;
            this.count = count;
            this.umbrella = umbrella;
            this.used = new HashMap<>(used);
        }

        public static Player from(final int hp) {
            return new Player(hp, 0, 0, new HashMap<>());
        }


        public void move(int x, int y) {
            check(x, y);
            if (isEnd()) {
                return;
            }
            this.count += 1;
            for (Direction direction : Direction.values()) {
                int nextX = x + direction.x;
                int nextY = y + direction.y;
                if (canMove(nextX, nextY) && visited[nextX][nextY] > count) {
                    visited[nextX][nextY] = count;
                    new Player(hp, count, umbrella, used).move(nextX, nextY);
                }
            }
        }

        private boolean isEnd() {
            if (hp == 0) {
                return true;
            }
            return count >= answer;
        }

        private void check(int x, int y) {
            Field f = list[x][y];
            switch (f) {
                case TOXIC:
                    moveToxic();
                    break;
                case END:
                    moveEnd();
                    break;
                case UMBRELLA:
                    moveUmbrella(x, y);
                    moveToxic();
                    break;
                default:
            }
        }

        private void moveUmbrella(int x, int y) {
            if (used.containsKey(x * 500 + y)) {
                return;
            }
            used.put(x * 500 + y, true);
            umbrella = d;
        }

        private void moveToxic() {
            if (umbrella > 0) {
                this.umbrella -= 1;
                return;
            }
            if (hp > 0) {
                this.hp -= 1;
            }
        }

        private void moveEnd() {
            answer = Math.min(answer, count);
        }

        private boolean canMove(int x, int y) {
            return 0 <= x && x < n && 0 <= y && y < n)
        }
    }

    private enum Direction {
        UP(-1, 0),
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1);
        private final int x;
        private final int y;

        Direction(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

    }

    private enum Field {
        START('S'),
        TOXIC('.'),
        UMBRELLA('U'),
        END('E');
        private final char value;

        Field(final char value) {
            this.value = value;
        }

        public static Field from(final char value) {
            for (final Field field : values()) {
                if (field.value == value) {
                    return field;
                }
            }
            return null;
        }
    }
}
