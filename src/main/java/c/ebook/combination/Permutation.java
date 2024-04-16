package c.ebook.combination;

public class Permutation {
    public static void main(String[] args) {
        int N = 4 ;
        long F[] = new long[21] ;
        int S[] = new int[21] ;

        boolean visited[] = new boolean[21];
        F[0] = 1;
        for(int i=1; i<=N; i++) {
            F[i] = F[i-1] * i ;
        }

        int Q = 1 ;

        if(Q == 1) {

            int K = 3;

            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j]) continue;

                    System.out.println("K=" + K +" ,cnt=" + cnt + " ,F[N-i]=" + F[N-i] + ", j=" + j);
                    if (K <= cnt * F[N - i]) {  // cnt=1,F[3] -> cnt=1,F[2] : PASS -> cnt=2, F[1]
                        K -= ((cnt - 1) * F[N - i]);     // K -= 0 -> K -=0
                        S[i] = j;   // S[1] = 1 ->
                        visited[j] = true;  // visited[1] = true ->
                        break;
                    }

                    cnt++;
                }
            }

            for (int i = 1; i <= N; i++) {
                System.out.print(S[i] + " ");
            }
        } else {
            long K = 1;

            S[1] = 1;
            S[2] = 3;
            S[3] = 2;
            S[4] = 4;

            for(int i=1 ; i <=N; i++) {
                long cnt = 0;

                for(int j = 1; j < S[i]; j++) {
                    if(!visited[j]) {
                        cnt ++;
                    }
                }
                K += cnt * F[N -i ];
                visited[S[i]] = true ;
            }

            System.out.println(K + "th");
        }
    }
}
