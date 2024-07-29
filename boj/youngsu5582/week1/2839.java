import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(reader.readLine());

        int result = Integer.MAX_VALUE;

        for(int i = 0; i*5 <=n; i++) {
            for(int j = 0; i*5 + j*3 <=n; j++) {
                if(i*5 + j*3 == n){
                    result = Math.min(result,i+j);
                }
            }
        }

        if(result==Integer.MAX_VALUE){
            sb.append(-1);
        }else{
            sb.append(result);
        }

        System.out.println(sb);
    }
}
