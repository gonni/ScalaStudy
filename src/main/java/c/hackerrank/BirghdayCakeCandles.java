package c.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BirghdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Collections.sort(candles);

        int targetCandle = candles.get(candles.size() - 1);;
        int counter = 0;
        for(int i = candles.size() -1; i >= 0; i-- ) {
            if(candles.get(i) == targetCandle) counter ++;
            else break ;
        }
        return counter;
    }

    public static void main(String[] args) {
        ArrayList<Integer> candles = new ArrayList<>();
        candles.add(3);
        candles.add(2);
        candles.add(1);
        candles.add(3);

        System.out.println("Count ->" + birthdayCakeCandles(candles));
    }
}
