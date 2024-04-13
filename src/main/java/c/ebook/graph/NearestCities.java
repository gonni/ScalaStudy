package c.ebook.graph;

import java.util.*;

public class NearestCities {
    static ArrayList<Integer>[] edges = new ArrayList[5];
    static int[] visited = new int[5];

    public static void init() {
        // init



    }

    public static void bfs(int city) {
        for(int i=0;i<edges.length;i++) {
            edges[i] = new ArrayList<>();
        }
        edges[1].add(2);
        edges[1].add(3);
        edges[2].add(3);
        edges[2].add(4);

        for(int i=0;i<visited.length;i++) {
            visited[i] = -1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(city);
        visited[city] = 0;

        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int nd : edges[cur]) {
                if(visited[nd] == -1) {
                    visited[nd] = visited[cur] + 1;
                    q.add(nd);
                }
            }
        }
    }

    public static void main(String[] args) {

        bfs(1);
        for(int i=0;i<visited.length;i++) {
            System.out.println(visited[i]);
        }
    }
}
