package c.ebook.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HackerRoute {
    final int countNodes = 5;

    ArrayList<Integer>[] pcs = null ;
    boolean[] visited = new boolean[countNodes+1];
    int[] answer;

    public HackerRoute() {
        pcs = new ArrayList[countNodes+1];
        for(int i=0;i<pcs.length;i++) {
            pcs[i] = new ArrayList<>();
//            visited[i] = -1;
        }
        answer = new int[countNodes + 1];
    }

    public void add(int from, int to) {
        pcs[from].add(to);
//        pcs[to].add(from);
    }

    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int nd: pcs[cur]) {
                if(visited[nd] == false) {
                    visited[nd] = true;
//                    q.add(nd);
                    answer[nd] = answer[nd] + 1;
                    q.add(nd);
                }
            }
        }

        for(int i=0;i<answer.length;i++) {
            System.out.print(answer[i] + "\t");
        }
    }

    public void cleanVisited() {
        for(int i=0;i<visited.length;i++) {
            visited[i] = false;
//            answer[i] = 0;
        }
    }

    public static void main(String[] args) {
        HackerRoute test = new HackerRoute();
        test.add(3,1);
        test.add(3,2);
        test.add(4,3);
        test.add(5,3);

        for(int i=0;i<=test.countNodes;i++) {
            test.cleanVisited();
            System.out.println("==>" + i);
            test.bfs(i);
            System.out.println();

        }
    }
}
