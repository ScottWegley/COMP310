package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

import GraphAlgorithms.Edge.ConnectionType;

public class WeightedGenAdjacencyList<T> {
    public HashMap<T, ArrayList<T>> map;
    private HashMap<T, HashMap<T, Integer>> weights;

    public void add(WeightedEdge<T> e) {
        if (!map.containsKey(e.fromNode())) {
            map.put(e.fromNode(), new ArrayList<>());
            weights.put(e.fromNode(), new HashMap<>());
        }
        map.get(e.fromNode()).add(e.toNode());
        weights.get(e.fromNode()).put(e.toNode(), e.weight());
        if (e.type() == ConnectionType.BIDIRECTIONAL) {
            if (!map.containsKey(e.toNode())) {
                map.put(e.toNode(), new ArrayList<>());
                weights.put(e.toNode(), new HashMap<>());
            }
            map.get(e.toNode()).add(e.fromNode());
            weights.get(e.toNode()).put(e.fromNode(), e.weight());
        }
    }

    public WeightedGenAdjacencyList(WeightedEdge<T>[] eArr) {
        map = new HashMap<>();
        weights = new HashMap<>();
        for (WeightedEdge<T> e : eArr) {
            add(e);
        }
    }

    public int getWeight(T from, T to) {
        if (!weights.containsKey(from)) {
            throw new IllegalArgumentException("There is no connections originating from " + from + ".");
        }
        ;
        if (!weights.get(from).containsKey(to)) {
            throw new IllegalArgumentException(
                    "There is no connection orginating from " + from + " and ending at " + to + ".");
        }
        return weights.get(from).get(to);
    }
}
