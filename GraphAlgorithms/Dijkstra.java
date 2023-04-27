package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

import GraphAlgorithms.Edge.ConnectionType;
import Library.AlgoTools;

public class Dijkstra {

    /**
     * Returns whether or not a node is currently in our list of connections
     * 
     * @param set     A HashMap of nodes mapped to a list of all other nodes they
     *                are connected to
     * @param toCheck The node we are looking for in our list of connections
     * @return True is there is a connection, false if there is not a connection
     */
    private static <T> boolean connected(HashMap<T, ArrayList<T>> set, T toCheck) {
        for (T key : set.keySet()) {
            if (set.get(key).contains(toCheck)) {
                return true;
            }
        }
        return false;
    }
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

        // Populates our ouptut and fringe with a list so that every node may have
        // connections.
        for (T key : adjList.map.keySet()) {
            output.put(key, new ArrayList<T>());
            fringe.put(key, new ArrayList<T>());
            paths.put(key, new ArrayList<>());
        }

        // Initial fringe set up.
        for (T connectedNode : adjList.map.get(_s)) {
            fringe.get(_s).add(connectedNode);
            paths.get(connectedNode).add(new WeightedEdge<>(_s, connectedNode, adjList.getWeight(_s, connectedNode)));
        }

        while (!connected(output, _d)) {
            int min = 2147483647;
            T start = null;
            T end = null;
            // Loop through all fringe connections and store the one with the least weight.
            for (T origin : fringe.keySet()) {
                for (T destination : fringe.get(origin)) {
                    if (adjList.getWeight(origin, destination) < min) {
                        min = adjList.getWeight(origin, destination);
                        start = origin;
                        end = destination;
                    }
                }
            }
            if (start == null || end == null) {
                continue;
            }
            output.get(start).add(end);
            fringe.get(start).remove(end);
            break;
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
