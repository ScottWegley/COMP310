package GraphTraversal;

import java.util.ArrayList;

import GraphTraversal.Edge.ConnectionType;

public class AdjacencyList {
    ArrayList<Integer>[] list;

    private int N;

    public AdjacencyList(int _N){
        list = new ArrayList[_N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }
    }

    public void add(Edge e){
        if(Math.max(e.fromNode(), e.toNode()) > N){
            throw new IllegalArgumentException("An adjacency list of size " + N + " cannot have an edge involving the ID " + Math.max(e.fromNode(), e.toNode()));
        }
        list[e.fromNode()-1].add(e.toNode());
        if(e.type() == ConnectionType.BIDIRECTIONAL){
            list[e.toNode()-1].add(e.fromNode());
        }
    }

    public AdjacencyList(Edge[] eArr){
        int max = 0;
        for (Edge e : eArr) {
            if(Math.max(e.fromNode(),e.toNode()) > max){
                max = Math.max(e.fromNode(), e.toNode());
            }
        }
        N = max;
        list = new ArrayList[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (Edge e : eArr) {
            add(e);
        }
    }
}
