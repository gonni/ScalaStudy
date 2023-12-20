package c.x.codingtest.mid;

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets,(o1,o2)-> {
            return o1[1]-o2[1];
        });

        for(int i=0; i<targets.length; i++) {
            System.out.println(targets[i][0] + ", " + targets[i][1]);
        }

        int x = 0;

        for(int i=0;i<targets.length;i++){
            //System.out.println(targets[i][0]);
            if(x<=targets[i][0]){
                x = targets[i][1];
                System.out.println("=>" + targets[i][0] + ", " + targets[i][1]);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] sample = {
                {4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        new Solution().solution(sample);

    }
}