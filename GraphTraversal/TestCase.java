package GraphTraversal;

import GraphTraversal.Edge.ConnectionType;
import Library.AlgoTools;

public class TestCase {
    public static void main(String[] args) {
        Edge[] fig8_1a = new Edge[] {
                new Edge(1, 2, ConnectionType.BIDIRECTIONAL),
                new Edge(1, 3, ConnectionType.BIDIRECTIONAL),
                new Edge(2, 4, ConnectionType.BIDIRECTIONAL),
                new Edge(2, 3, ConnectionType.BIDIRECTIONAL),
                new Edge(3, 5, ConnectionType.BIDIRECTIONAL),
                new Edge(5, 4, ConnectionType.BIDIRECTIONAL)
        };
        Edge[] fig8_1b = new Edge[] {
                new Edge(1, 2, ConnectionType.BIDIRECTIONAL),
                new Edge(1, 3),
                new Edge(3, 2),
                new Edge(4, 3),
                new Edge(4, 5, ConnectionType.BIDIRECTIONAL),
                new Edge(5, 2)
        };

        AdjacencyMatrix adj8_1a = new AdjacencyMatrix(fig8_1a);
        AdjacencyMatrix adj8_1b = new AdjacencyMatrix(fig8_1b);

        System.out.println("Matrix for 8-1a");
        AlgoTools.printMatrix(adj8_1a.matrix);
        System.out.println("Matrix for 8-1b");
        AlgoTools.printMatrix(adj8_1b.matrix);
    }
}
