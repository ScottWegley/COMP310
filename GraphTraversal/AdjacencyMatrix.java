package GraphTraversal;

import GraphTraversal.Edge.ConnectionType;

public class AdjacencyMatrix {
    
    int[][] matrix;
    private int N;

    public AdjacencyMatrix(int _N){
        matrix = new int[_N][_N];
        N = _N;
    }

    public void add(Edge e) throws IllegalArgumentException{
        if(Math.max(e.fromNode(), e.toNode()) > N){
            throw new IllegalArgumentException("An adjacency matrix of size " + N + " cannot have an edge involving the ID " + Math.max(e.fromNode(), e.toNode()));
        }
        matrix[e.fromNode()-1][e.toNode()-1] = 1;
        if(e.type() == ConnectionType.BIDIRECTIONAL){
            matrix[e.toNode()-1][e.fromNode()-1] = 1;
        }
    }

    public AdjacencyMatrix(Edge[] eArr){
        int max = 0;
        for (Edge e : eArr) {
            if(Math.max(e.fromNode(),e.toNode()) > max){
                max = Math.max(e.fromNode(), e.toNode());
            }
        }
        N = max;
        matrix = new int[N][N];
        for (Edge e : eArr) {
            add(e);
        }
    }
}
