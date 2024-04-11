package c.ebook;

public class TwoPointSum {
    public static void main(String[] args) {
        int count =0, startIdx = 0, endIdx = 0, tempSum = 0;
        int N = 15;

        while(endIdx <= N) {
            if(tempSum == N) {
                count ++;
                endIdx ++ ;
                tempSum += endIdx;
            } else if(tempSum > N) {
                tempSum -= startIdx;
                startIdx ++;
            } else {
                endIdx++;
                tempSum += endIdx;
            }
        }

        System.out.println("count of N => " +  count);
    }
}
