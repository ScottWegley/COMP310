package GraphAlgorithms;

import Library.AlgoTools;
import Library.Edge;
import Library.GenAdjacencyList;
import Library.WeightedEdge;
import Library.Edge.ConnectionType;

public class TestCase {

    static Edge[][] arrs = new Edge[][] {
            {
                    new WeightedEdge<String>("A", "B", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("A", "F", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("B", "C", ConnectionType.BIDIRECTIONAL, 5),
                    new WeightedEdge<String>("B", "E", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("B", "G", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("C", "E", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("C", "H", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("D", "F", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("D", "G", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("D", "E", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("E", "H", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("F", "G", ConnectionType.BIDIRECTIONAL, 1),
                    new WeightedEdge<String>("G", "H", ConnectionType.BIDIRECTIONAL, 1)
            },
            {
                    new WeightedEdge<String>("A", "B", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("A", "C", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("A", "D", ConnectionType.BIDIRECTIONAL, 6),
                    new WeightedEdge<String>("B", "C", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("B", "E", ConnectionType.BIDIRECTIONAL, 6),
                    new WeightedEdge<String>("C", "D", ConnectionType.BIDIRECTIONAL, 1),
                    new WeightedEdge<String>("C", "E", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("D", "E", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("D", "F", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("E", "G", ConnectionType.BIDIRECTIONAL, 5),
                    new WeightedEdge<String>("F", "G", ConnectionType.BIDIRECTIONAL, 4)
            },
            {
                    new WeightedEdge<String>("A", "B", ConnectionType.BIDIRECTIONAL, 1),
                    new WeightedEdge<String>("A", "D", ConnectionType.BIDIRECTIONAL, 5),
                    new WeightedEdge<String>("A", "F", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("B", "E", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("C", "E", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("C", "H", ConnectionType.BIDIRECTIONAL, 1),
                    new WeightedEdge<String>("D", "E", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("D", "G", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("E", "G", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("F", "G", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("G", "H", ConnectionType.BIDIRECTIONAL, 5)
            },
            {
                    new WeightedEdge<String>("A", "B", ConnectionType.BIDIRECTIONAL, 1),
                    new WeightedEdge<String>("A", "D", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("B", "C", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("B", "E", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("C", "D", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("D", "E", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("D", "F", ConnectionType.BIDIRECTIONAL, 2),
                    new WeightedEdge<String>("E", "F", ConnectionType.BIDIRECTIONAL, 5),
                    new WeightedEdge<String>("E", "H", ConnectionType.BIDIRECTIONAL, 3),
                    new WeightedEdge<String>("F", "G", ConnectionType.BIDIRECTIONAL, 4),
                    new WeightedEdge<String>("F", "H", ConnectionType.BIDIRECTIONAL, 5),
                    new WeightedEdge<String>("G", "H", ConnectionType.BIDIRECTIONAL, 1)
            }
    };

    public static void main(String[] args) {
        GenAdjacencyList[] lists = new GenAdjacencyList[arrs.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new GenAdjacencyList<>(arrs[i]);
            System.out.println("Graph " + (i + 1));
            AlgoTools.printGenAdjacencyList(lists[i].map);
        }
    }
}
