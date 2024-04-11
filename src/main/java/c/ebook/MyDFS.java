package c.ebook;

import java.util.ArrayList;
import java.util.Stack;

public class MyDFS {

    private ArrayList<Integer> nodes[] = null ;
    private int cntNodes ;

    MyDFS(int _cntNodes) {
        cntNodes = _cntNodes;
        nodes = new ArrayList[cntNodes];
        for(int i=0;i<cntNodes;i++) {
            nodes[i] = new ArrayList<>();
        }
    }

    void addEdge(int node, int toNode) {
        nodes[node].add(toNode);
    }

    public void dfs(int startNode) {
        boolean[] visited = new boolean[cntNodes];
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        visited[startNode] = true;

        int acvNode ;
        while(!stack.isEmpty()) {
            acvNode = stack.pop();
            System.out.print(acvNode + "->");

            for(int node : nodes[acvNode]) {
                if(!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Active ...") ;

        MyDFS dfs = new MyDFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        dfs.dfs(2);

    }

}

class Node {
    int number ;
    ArrayList<Integer> linkNode ;
}
