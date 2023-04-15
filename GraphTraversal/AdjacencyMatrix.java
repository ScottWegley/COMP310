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

    public void add(Edge[] eArr){
        for (Edge e : eArr) {
            add(e);
        }
    }
}
