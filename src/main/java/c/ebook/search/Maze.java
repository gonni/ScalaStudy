package c.ebook.search;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited ;
    static int[][] A = {
            {1,0,1,1,1,1},
            {1,0,1,0,1,0},
            {1,0,1,0,1,1},
            {1,1,1,0,1,1}
    };
    static int N, M;

    public static void init() {
        visited = new boolean[A.length][A[0].length];
        N = A.length;
        M = A[0].length;
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true ;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i=0;i<4;i++) {
                int x = cur[0] + dx[i] ;
                int y = cur[1] + dy[i] ;

                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Maze.init();
        Maze.bfs(0,0);

        System.out.println("Final stage => " + A[N-1][M-1]);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
