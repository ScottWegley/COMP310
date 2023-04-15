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

        AdjacencyMatrix adjMat8_1a = new AdjacencyMatrix(fig8_1a);
        AdjacencyMatrix adjMat8_1b = new AdjacencyMatrix(fig8_1b);

        AdjacencyList adjList8_1a = new AdjacencyList(fig8_1a);
        AdjacencyList adjList8_1b = new AdjacencyList(fig8_1b);

        System.out.println("Matrix for 8-1a");
        AlgoTools.printMatrix(adjMat8_1a.matrix);
        System.out.println("Matrix for 8-1b");
        AlgoTools.printMatrix(adjMat8_1b.matrix);

        System.out.println("List for 8-1a");
        for (int i = 0; i < adjList8_1a.list.length; i++) {
            System.out.print((i+1) + ":  ");
            for (int q : adjList8_1a.list[i]) {
                System.out.print(q + ",  ");
            }
            System.out.print('\n');
        }
        System.out.println("List for 8-1b");
        for (int i = 0; i < adjList8_1b.list.length; i++) {
            System.out.print((i+1) + ":  ");
            for (int q : adjList8_1b.list[i]) {
                System.out.print(q + ",  ");
            }
            System.out.print('\n');
        }
    }
}
