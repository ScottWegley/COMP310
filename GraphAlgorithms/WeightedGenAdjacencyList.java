package GraphAlgorithms;

import java.util.HashMap;

import GraphAlgorithms.Edge.ConnectionType;

public class WeightedGenAdjacencyList<T> {
    public HashMap<T, HashMap<T, Integer>> map;

    public void add(WeightedEdge<T> e) {
        if (!map.containsKey(e.fromNode())) {
            map.put(e.fromNode(), new HashMap<>());
        }
        map.get(e.fromNode()).put(e.toNode(), e.weight());
        if (e.type() == ConnectionType.BIDIRECTIONAL) {
            if (!map.containsKey(e.toNode())) {
                map.put(e.toNode(), new HashMap<>());
            }
            map.get(e.toNode()).put(e.fromNode(), e.weight());
        }
    }

    public WeightedGenAdjacencyList(WeightedEdge<T>[] eArr) {
        map = new HashMap<>();
        for (WeightedEdge<T> e : eArr) {
            add(e);
        }
    }

    public int getWeight(T from, T to) {
        if (!map.containsKey(from)) {
            throw new IllegalArgumentException("There is no connections originating from " + from + ".");
        }
        ;
        if (!map.get(from).containsKey(to)) {
            throw new IllegalArgumentException(
                    "There is no connection orginating from " + from + " and ending at " + to + ".");
        }
        return map.get(from).get(to);
    }
}
