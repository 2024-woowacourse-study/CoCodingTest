import java.io.IOException;
import java.util.*;

public class Main {
    private static Map<String, Integer> mp = new HashMap<>();

    public static void main(final String[] args){
        String[] players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] answers = new String[]{"kai", "kai", "mine", "mine"};
        Arrays.stream(solution(players,answers)).forEach(System.out::println);
    }

    public static String[] solution(String[] players, String[] callings) {
        init(players);
        for (String calling : callings) {
            int index = find(calling);
            swap(players,calling,index);
        }
        return players;
    }
    private static void init(String[] players){
        for(int i = 0; i<players.length; i++){
            mp.put(players[i],i);
        }
    }
    private static int find(String answer){
        return mp.get(answer);
    }

    public static void swap(String[] ls, String calling, int index) {
        String change = ls[index-1];
        ls[index-1]= calling;
        mp.put(calling,index-1);
        ls[index] = change;
        mp.put(change,index);
    }
}
