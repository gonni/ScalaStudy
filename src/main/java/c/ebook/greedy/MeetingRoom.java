package c.ebook.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

    public static void main(String[] args) {
        int N = 11;
        int[][] meetings = {
                {1,4},
                {3,5},
                {0,6},
                {5,7},
                {3,8},
                {5,9},
                {6,10},
                {8,11},
                {8,12},
                {2,13},
                {12,14}
        };

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int startPoint = 0;
        for(int i=0; i< meetings.length; i++) {
            if(meetings[i][0] >= startPoint) {
                startPoint = meetings[i][1];
                count ++;
            }
        }

        System.out.println("Count -> " + count);

        System.out.println(Math.sqrt(100));
    }
}
