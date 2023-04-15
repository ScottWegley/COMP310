package GraphTraversal;

public class Edge {
   
    public enum ConnectionType {
        UNIDIRECTIONAL,
        BIDIRECTIONAL
    }

    private int privFromNode, privToNode;
    ConnectionType privType;

    public Edge(int _fromNode, int _toNode){
        this(_fromNode,_toNode,ConnectionType.UNIDIRECTIONAL);
    }

    public Edge(int _fromNode, int _toNode, ConnectionType _type){
        privFromNode = _fromNode;
        privToNode = _toNode;
        privType = _type;
    }

    public int fromNode(){
        return privFromNode;
    }

    public int toNode(){
        return privToNode;
    }

    public ConnectionType type(){
        return privType;
    }

}