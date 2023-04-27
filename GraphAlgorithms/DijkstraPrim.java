package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import GraphAlgorithms.Edge.ConnectionType;
import Library.AlgoTools;

public class DijkstraPrim {

    private static <T> boolean connectionsExist(HashMap<T, ArrayList<T>> check) {
        for (T key : check.keySet()) {
            if (check.get(key).size() > 0) {
                return true;
            }
        }
        return false;
    }

    public static <T> void run(WeightedGenAdjacencyList<T> adjList, T _v) {
        HashMap<T, ArrayList<T>> output = new HashMap<>();
        HashMap<T, ArrayList<T>> fringe = new HashMap<>();
        ArrayList<T> mapped = new ArrayList<>();

        // Populates our ouptut with a list so that every node may have connections.
        for (T key : adjList.map.keySet()) {
            output.put(key, new ArrayList<T>());
            fringe.put(key, new ArrayList<T>());
        }

        // Initial Fringe Setup
        for (T connectedNode : adjList.map.get(_v)) {
            fringe.get(_v).add(connectedNode);
            mapped.add(connectedNode);
        }
        mapped.add(_v);

        // While there are still connections in the fringe
        while (connectionsExist(fringe)) {
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
            // Add the smallest connection to the output and remove it from the fringe.
            output.get(start).add(end);
            fringe.get(start).remove(end);

            // Update the fringe
            for (T destination : adjList.map.get(end)) {
                // Add every brand new node from our recent addition to fringe
                if (!mapped.contains(destination)) {
                    mapped.add(destination);
                    fringe.get(end).add(destination);
                } else { // For every previously existing node
                    T existing = null;
                    for (T t : fringe.keySet()) {
                        if (fringe.get(t).contains(destination)) {
                            existing = t;
                            break;
                        }
                    } // Find and store the origin of the already existing connection.
                    if (existing == null) {
                        continue;
                    } // If new connection is cheaper than existing, remove old, add the new.
                    if (adjList.getWeight(end, destination) < adjList.getWeight(existing, destination)) {
                        fringe.get(existing).remove(destination);
                        fringe.get(end).add(destination);
                    }
                }
            }
        }

        HashMap<T, T> toReverse = new HashMap<T, T>();
        for (T key : output.keySet()) {
            for (T value : output.get(key)) {
                if (adjList.map.get(value).contains(key)) {
                    toReverse.put(value, key);
                }
            }
        }

        for (Map.Entry<T, T> entry : toReverse.entrySet()) {
            output.get(entry.getKey()).add(entry.getValue());
        }

        AlgoTools.printGenAdjacencyList(output);
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
        // AlgoTools.printGenAdjacencyList(input.map);
        run(input, "A");
    }
}
