package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

import GraphAlgorithms.Edge.ConnectionType;
import Library.AlgoTools;

public class DijkstraPrim {

    public static <T> void run(WeightedGenAdjacencyList<T> adjList, T _v) {
        HashMap<T, ArrayList> output = new HashMap<>();
        HashMap<T, ArrayList> fringe = new HashMap<>();

        // Populates our ouptut with a list so that every node may have connections.
        for (T key : adjList.map.keySet()) {
            output.put(key, new ArrayList<T>());
        }

        // Initial Fringe Setup
        fringe.put(_v, new ArrayList<>());
        for (T connectedNode : adjList.map.get(_v)) {
            fringe.get(_v).add(connectedNode);
        }

        AlgoTools.printGenAdjacencyList(fringe);
    }

    public static void main(String[] args) {
        WeightedEdge[] arr = new WeightedEdge[] {
            new WeightedEdge<String>("A", "B",ConnectionType.BIDIRECTIONAL, 2),
            new WeightedEdge<String>("A", "C",ConnectionType.BIDIRECTIONAL, 4),
            new WeightedEdge<String>("A", "D",ConnectionType.BIDIRECTIONAL, 7),
            new WeightedEdge<String>("A", "F",ConnectionType.BIDIRECTIONAL, 5),
            new WeightedEdge<String>("B", "D",ConnectionType.BIDIRECTIONAL, 6),
            new WeightedEdge<String>("B", "E",ConnectionType.BIDIRECTIONAL, 3),
            new WeightedEdge<String>("B", "G",ConnectionType.BIDIRECTIONAL, 8),
            new WeightedEdge<String>("C", "F",ConnectionType.BIDIRECTIONAL, 6),
            new WeightedEdge<String>("D", "F",ConnectionType.BIDIRECTIONAL, 1),
            new WeightedEdge<String>("D", "G",ConnectionType.BIDIRECTIONAL, 6),
            new WeightedEdge<String>("E", "G",ConnectionType.BIDIRECTIONAL, 7),
            new WeightedEdge<String>("F", "G",ConnectionType.BIDIRECTIONAL, 6),
        };

        WeightedGenAdjacencyList input = new WeightedGenAdjacencyList<>(arr);
        // AlgoTools.printGenAdjacencyList(input.map);
        run(input, "A");
    }
}
