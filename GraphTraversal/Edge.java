package GraphTraversal;

public class Edge<T> {
   
    public enum ConnectionType {
        UNIDIRECTIONAL,
        BIDIRECTIONAL
    }

    private T privFromNode, privToNode;
    ConnectionType privType;

    public Edge(T _fromNode, T _toNode){
        this(_fromNode,_toNode,ConnectionType.UNIDIRECTIONAL);
    }

    public Edge(T _fromNode, T _toNode, ConnectionType _type){
        privFromNode = _fromNode;
        privToNode = _toNode;
        privType = _type;
    }

    public T fromNode(){
        return privFromNode;
    }

    public T toNode(){
        return privToNode;
    }

    public ConnectionType type(){
        return privType;
    }

}