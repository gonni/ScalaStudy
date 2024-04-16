package c.hackerrank;

import java.util.List;

public class DiagonalDiff {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0;
        for(int i=0;i< arr.size();i++ ) {
            int j = i;
            sum1 += arr.get(i).get(j);
        }
        int sum2 = 0;
        for(int i=0;i< arr.size();i++) {
            int j = arr.size() -1 -i;
            sum2 += arr.get(i).get(j);
        }

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {

    }

}
