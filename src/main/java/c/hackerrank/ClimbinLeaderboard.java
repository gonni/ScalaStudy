package c.hackerrank;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ClimbinLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int previous = -1;
        LinkedHashMap<Integer, Integer> rank = new LinkedHashMap<>();

        int curRank = 0;
        int prevScore = -1;
        int lastRankNo = -1;
        for(int i=0;i<ranked.size();i++) {
            if(ranked.get(i) != prevScore) {
                curRank ++;
                rank.put(ranked.get(i), curRank);
                lastRankNo = curRank;
            }
            prevScore = ranked.get(i);
        }
        System.out.println("rank length :" + rank.size());




        ArrayList<Integer> result = new ArrayList<>();
        boolean confirmed = false;
        for(int playScore : player) {
            System.out.println("check num => " + playScore);
            confirmed = false;
            for(int i=0; i<ranked.size(); i++) {
                if(playScore >= ranked.get(i)) {
                    confirmed = true;
                    if(i == 0) {
                        result.add(1);
                    } else if(i == ranked.size() - 1 && ranked.get(i) > playScore)
                        result.add(rank.get(rank.size() -1) + 1);
                    else {
                        result.add(rank.get(ranked.get(i)));
                    }
                    break ;
                }
            }
            if(!confirmed) {
                result.add(lastRankNo + 1);
            }
        }

        return result ;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ranked = new ArrayList<>();
        ranked.add(100);
        ranked.add(100);
        ranked.add(50);
        ranked.add(40);
        ranked.add(20);
        ranked.add(10);

        ArrayList<Integer> player = new ArrayList<>();
        player.add(5);
        player.add(25);
        player.add(50);
        player.add(120);

        System.out.println("----------------");
        climbingLeaderboard(ranked, player).forEach(System.out::println);

    }
}
