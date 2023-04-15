package GraphTraversal;

import GraphTraversal.Edge.ConnectionType;

public class AdjacencyMatrix {
    
    int[][] matrix;
    private int N;

    public AdjacencyMatrix(int _N){
        matrix = new int[_N][_N];
        N = _N;
    }
}
