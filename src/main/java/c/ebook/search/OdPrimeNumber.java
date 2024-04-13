package c.ebook.search;

public class OdPrimeNumber {

    public static void DFS(int num, int length) {
        if(length == 4) {
            if(isPrimeNumber(num))
                System.out.println(num);
            return ;
        }

        for(int i=0;i<10;i++) {
            if(i % 2 == 0) continue;
            if(isPrimeNumber(num * 10 + i)) {
                DFS(num * 10 + i, length + 1);
            }
        }
    }


    public static boolean isPrimeNumber(int num) {
        for(int i=2;i<Math.sqrt(num);i++) {
            if(num % i == 0) return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
        System.out.println("100 -> " + Math.sqrt(100));
        System.out.println("13 -> " + isPrimeNumber(14));

        DFS(2, 1);
        System.out.println("------------------");
        DFS(3, 1);
        System.out.println("------------------");
        DFS(5, 1);
        System.out.println("------------------");
        DFS(7, 1);
    }
}
