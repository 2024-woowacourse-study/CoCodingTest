import java.util.*;
import java.io.*;

public class Main{

    static int max=0;
    static int m;
    static int n;
    static int count = 0;
    static int[][] map;
    static long[][] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());

        map = new int[m+1][m+1];
        check = new long[m+1][m+1];

        for(int i=1; i<=m; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        check[1][1]=1;
        dp(1, 1);

        System.out.println(check[m][m]);
    }

    private static void dp(int startX, int startY){
        int num=0;

        for(int i=startX; i<=m;i++){
            for(int j=startY; j<=m; j++){
                num = map[i][j];
                if(i+num<=m && num !=0){
                    check[i+num][j] +=check[i][j];
                }
                if(j+num<=m && num !=0){
                    check[i][j+num] +=check[i][j];
                }
            }
        }
    }
}
