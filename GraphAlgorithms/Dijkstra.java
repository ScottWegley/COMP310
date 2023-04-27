package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

import GraphAlgorithms.Edge.ConnectionType;
import Library.AlgoTools;

public class Dijkstra {

    /**
     * Prints the shortest path from one node to another
     * 
     * @param adjList The Weighted Adjacency List of nodes to traverse
     * @param _s      The node to start from
     * @param _d      The destination node
     */
    public static <T> void run(WeightedGenAdjacencyList<T> adjList, T _s, T _d) {
        HashMap<T, ArrayList<T>> output = new HashMap<>();
        HashMap<T, ArrayList<T>> fringe = new HashMap<>();
        HashMap<T, ArrayList<WeightedEdge<T>>> paths = new HashMap<>();

        if (!adjList.map.keySet().contains(_s) || !adjList.map.keySet().contains(_d)) {
            throw new IllegalArgumentException(
                    "The specified start or destination does not exist in your adjacency list.");
        }

    }

    public static void main(String[] args) {
        WeightedEdge[] arr = new WeightedEdge[] {
                new WeightedEdge<String>("A", "B", ConnectionType.BIDIRECTIONAL, 2),
                new WeightedEdge<String>("A", "C", ConnectionType.BIDIRECTIONAL, 4),
                new WeightedEdge<String>("A", "D", ConnectionType.BIDIRECTIONAL, 7),
                new WeightedEdge<String>("A", "F", ConnectionType.BIDIRECTIONAL, 5),
                new WeightedEdge<String>("B", "D", ConnectionType.BIDIRECTIONAL, 6),
                new WeightedEdge<String>("B", "E", ConnectionType.BIDIRECTIONAL, 3),
                new WeightedEdge<String>("B", "G", ConnectionType.BIDIRECTIONAL, 8),
                new WeightedEdge<String>("C", "F", ConnectionType.BIDIRECTIONAL, 6),
                new WeightedEdge<String>("D", "F", ConnectionType.BIDIRECTIONAL, 1),
                new WeightedEdge<String>("D", "G", ConnectionType.BIDIRECTIONAL, 6),
                new WeightedEdge<String>("E", "G", ConnectionType.BIDIRECTIONAL, 7),
                new WeightedEdge<String>("F", "G", ConnectionType.BIDIRECTIONAL, 6),
        };

        WeightedGenAdjacencyList input = new WeightedGenAdjacencyList<>(arr);
    }
}
