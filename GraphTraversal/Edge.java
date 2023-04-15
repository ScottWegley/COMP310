package GraphTraversal;

public class Edge<T> {
   
    public enum ConnectionType {
        UNIDIRECTIONAL,
        BIDIRECTIONAL
    }

    T fromNode, toNode;
    ConnectionType type;

    public Edge(T _fromNode, T _toNode){
        this(_fromNode,_toNode,ConnectionType.UNIDIRECTIONAL);
    }

    public Edge(T _fromNode, T _toNode, ConnectionType _type){
        fromNode = _fromNode;
        toNode = _toNode;
        type = _type;
    }
    
}