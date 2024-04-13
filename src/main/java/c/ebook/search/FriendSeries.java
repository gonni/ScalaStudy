package c.ebook.search;

import java.util.ArrayList;

public class FriendSeries {

    private int targetN ;
    private ArrayList<Integer>[] nodes = null ;
    private boolean[] visited ;
    public FriendSeries(int n) {
        targetN = n ;
        nodes = new ArrayList[targetN];
        visited = new boolean[n];

        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
    }

    public void addEdge(int base, int next) {
        nodes[base].add(next);
        nodes[next].add(base);
    }

    public void printNode() {
        for(int i=0;i<targetN;i++) {
            System.out.println("->" + i);
            nodes[i].forEach(System.out::println);
            System.out.println("--------------");
        }

    }
    boolean isAlive = false;
    public void dfs(int node, int length) {
        if(length == 5) {
            //System.out.println("Final Node -> " + node);
            isAlive = true;
            return ;
        }
        visited[node] = true;
        //System.out.println(" -->" + node + ":" + length);
        for(int nd : nodes[node]) {
            if(!visited[nd]) {
                dfs(nd, length + 1);
            }
        }
        visited[node] = false ;
    }

    public static void main(String ... v) {
        FriendSeries test = new FriendSeries(8);
        test.addEdge(1, 7);
        test.addEdge(3, 7);
        test.addEdge(4, 7);
        test.addEdge(3, 4);
        test.addEdge(4, 6);
        test.addEdge(3, 5);
        test.addEdge(0, 4);
        test.addEdge(2, 7);

        test.printNode();

        for(int i=0;i<8;i++) {
            test.isAlive = false;
            test.dfs(i, 1);

            System.out.println(i + " -> " + test.isAlive);
        }

    }

}
