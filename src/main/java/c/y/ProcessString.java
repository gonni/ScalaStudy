package c.y;

import java.util.ArrayList;
import java.util.List;

public class ProcessString {
    // 1223#(3)
    public static List<Integer> processing(String data) {
        int cnt = 'z' - 'a' + 1 ;
        List<Integer> result = new ArrayList<>();

        char[] chars = data.toCharArray();
        for(int j = data.length() -1; j >= 0; j--) {
            char ch = chars[j];
            if(ch >= '1' && ch <= '9') {


            } else if(ch == ')') {

            }
        }



        return null ;
    }

    public static void processingLog(String data) {

    }


    public static void main(String[] args) {
        System.out.println("Active ..");

        char a = 'a';
        char z = 'z';

        System.out.println("distance => " + (a - z));
    }

}
