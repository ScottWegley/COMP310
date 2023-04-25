package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

import GraphAlgorithms.Edge.ConnectionType;

public class GenAdjacencyList<T> {
    public HashMap<T,ArrayList<T>> map;

    public void add(Edge<T> e){
        if(!map.containsKey(e.fromNode())){
            map.put(e.fromNode(), new ArrayList<>());
        }
        map.get(e.fromNode()).add(e.toNode());
        if(e.type() == ConnectionType.BIDIRECTIONAL){
            if(!map.containsKey(e.toNode())){
                map.put(e.toNode(), new ArrayList<>());
            }
            map.get(e.toNode()).add(e.fromNode());
        }
    }

    public GenAdjacencyList(Edge<T>[] eArr){
        map = new HashMap<>();
        for (Edge<T> e : eArr) {
            add(e);
        }
    }
}
