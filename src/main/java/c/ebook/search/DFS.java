package c.ebook.search;

import java.util.*;

public class DFS {
    private int V; // 정점의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트

    // 그래프 생성
    DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // 정점에 간선 추가
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS
    void depthFirstSearch(int v) {
        // 방문한 노드를 위한 배열
        boolean visited[] = new boolean[V];

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 현재 노드를 스택에 추가하고 방문 표시
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            // 스택에서 현재 노드를 팝하고 출력
            v = stack.pop();
            System.out.print(v + " ");

            // 현재 노드와 인접한 모든 미방문 노드를 스택에 추가
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        DFS g = new DFS(4);

        // 간선 추가
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        g.depthFirstSearch(0);
    }
}