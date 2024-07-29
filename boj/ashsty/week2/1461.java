import java.util.*;
import java.io.*;

public class Main{

    static int max=0;
    static int n;
    static int countPlus=0;
    static int countMinus=0;
    static int count = 0;
    static List<Integer> plus;
    static List<Integer> minus;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str1 = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(str1.nextToken());
        n = Integer.parseInt(str1.nextToken());

        plus=new ArrayList<>();
        minus=new ArrayList<>();

        StringTokenizer str2 = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(str2.nextToken());
            max = Math.max(max, Math.abs(num));

            if(num>=0){
                plus.add(num);
            }
            else{
                minus.add(Math.abs(num));
            }
        }

        Collections.sort(plus);
        Collections.sort(minus);

        greedySejun(plus);
        greedySejun(minus);

        System.out.println(count - max);
    }

    private static void greedySejun(List<Integer> array){
        int flag = array.size() % n;
        int i = array.size() - 1;

        while (i>flag-1){
            count+=array.get(i)*2;
            i-=n;
        }

        if(flag>0){
            count+=array.get(i)*2;
        }
    }
}
