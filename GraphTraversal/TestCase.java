package GraphTraversal;

import GraphTraversal.Edge.ConnectionType;
import Library.AlgoTools;

public class TestCase {
    public static void main(String[] args) {
        Edge[][] arrs = new Edge[][] {
                {
                        new Edge(1, 4, ConnectionType.BIDIRECTIONAL),
                        new Edge(2, 7, ConnectionType.BIDIRECTIONAL),
                        new Edge(7, 5, ConnectionType.BIDIRECTIONAL),
                        new Edge(2, 5, ConnectionType.BIDIRECTIONAL),
                        new Edge(7, 3, ConnectionType.BIDIRECTIONAL),
                        new Edge(1, 2, ConnectionType.BIDIRECTIONAL),
                        new Edge(3, 4, ConnectionType.BIDIRECTIONAL),
                        new Edge(3, 6, ConnectionType.BIDIRECTIONAL),
                        new Edge(6, 5, ConnectionType.BIDIRECTIONAL),
                        new Edge(5, 4, ConnectionType.BIDIRECTIONAL)
                },
                {
                        new Edge(1, 5, ConnectionType.BIDIRECTIONAL),
                        new Edge(1, 4, ConnectionType.BIDIRECTIONAL),
                        new Edge(5, 6, ConnectionType.BIDIRECTIONAL),
                        new Edge(6, 7, ConnectionType.BIDIRECTIONAL),
                        new Edge(7, 4, ConnectionType.BIDIRECTIONAL),
                        new Edge(4, 3, ConnectionType.BIDIRECTIONAL),
                        new Edge(3, 2, ConnectionType.BIDIRECTIONAL),
                        new Edge(2, 4, ConnectionType.BIDIRECTIONAL),
                },
                {
                        new Edge(1, 5),
                        new Edge(1, 4),
                        new Edge(1, 2),
                        new Edge(5, 4),
                        new Edge(2, 4),
                        new Edge(2, 3),
                        new Edge(2, 7),
                        new Edge(7, 6),
                        new Edge(4, 6),
                        new Edge(4, 7),
                        new Edge(6, 5),
                        new Edge(3, 4)
                },
                {
                        new Edge(1, 5),
                        new Edge(1, 4),
                        new Edge(1, 2),
                        new Edge(5, 4),
                        new Edge(2, 3),
                        new Edge(4, 6),
                        new Edge(4, 7),
                        new Edge(4, 3),
                        new Edge(4, 2),
                        new Edge(6, 7),
                        new Edge(3, 7)
                }
        };

        AdjacencyMatrix matricies[] = new AdjacencyMatrix[4];
        AdjacencyList lists[] = new AdjacencyList[4];
        for (int i = 0; i < matricies.length; i++) {
            matricies[i] = new AdjacencyMatrix(arrs[i]);
            lists[i] = new AdjacencyList(arrs[i]);
            System.out.println("Graph " + (i+1));
            DepthFirstTraversal.run(matricies[i], 1);
            DepthFirstTraversal.run(lists[i],1);
            BreadthFirstTraversal.run(matricies[i], 1);
            BreadthFirstTraversal.run(lists[i],1);
            // System.out.println("Example " + (i+1));
            // AlgoTools.printMatrix(matricies[i].matrix);
            // AlgoTools.printList(lists[i].list);
        }

    }
}
