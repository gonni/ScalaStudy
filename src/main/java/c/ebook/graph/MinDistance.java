package c.ebook.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
// Daick
public class MinDistance {
    public static int V = 5, E = 6 ,K = 1; // V = node, E = edge, K = start node
    public static int distance[] ;
    public static boolean visited[] ;
    public static ArrayList<Edge> list[] ;
    public static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) {
        list = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for(int i =1 ;i <= V; i++)
            list[i] = new ArrayList<>();

        for(int i=0;i<=V;i++)
            distance[i] = Integer.MAX_VALUE;

        list[5].add(new Edge(1,1));
        list[1].add(new Edge(2,2));
        list[1].add(new Edge(3,3));
        list[2].add(new Edge(3,4));
        list[2].add(new Edge(4,5));
        list[3].add(new Edge(4,6));

        q.add(new Edge(K, 0));
        distance[K] = 0;

        while(!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            if(visited[c_v]) continue;;
            visited[c_v] = true;

            for(int i=0;i<list[c_v].size();i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;

                if(distance[next] > distance[c_v] + value) {
                    distance[next] = value + distance[c_v];
                    q.add(new Edge(next, distance[next]));  // ----
                }
            }
        }

        for(int i=1;i <= V;i++) {
            if(visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }

    }
}

class Edge implements Comparable<Edge> {
    int vertex, value ;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        if(this.value > e.value) return 1;
        else return -1;
    }
}