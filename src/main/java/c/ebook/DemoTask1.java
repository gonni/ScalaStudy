package c.ebook;

import java.util.Arrays;

public class DemoTask1 {

    public static int solution(int[] A) {
        Arrays.sort(A);
//        for(int i=0;i < A.length; i++) {
//            System.out.println("->" + A[i]);
//        }

        if(A[0] != 1) return 1;
        else {
            for(int i=0;i<A.length -1;i++) {
                if(A[i+1] - A[i] > 1) {
                    return A[i] + 1;
                }
            }
        }

        return A[A.length -1] + 1;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,4,5,7}));
        System.out.println(solution(new int[] {1,7}));
        System.out.println(solution(new int[] {1,1}));
        System.out.println(solution(new int[] {2,3}));
    }
}
