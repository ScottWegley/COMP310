package GraphTraversal;

public class Edge {
   
    public enum ConnectionType {
        /** Represents an Edge where you can only traverse in one direction. */
        UNIDIRECTIONAL,
        /** Represents an Edge where you can traverse in either direction. */
        BIDIRECTIONAL
    }

    private int privFromNode, privToNode;
    ConnectionType privType;

    /**
     * Creates a unidirectional edge between two nodes.
     * @param _fromNode The node the edge originates from.
     * @param _toNode The node the edge ends at.
     */
    public Edge(int _fromNode, int _toNode){
        this(_fromNode,_toNode,ConnectionType.UNIDIRECTIONAL);
    }

    /**
     * Creates an edge of a specified type between two nodes. 
     * @param _fromNode The node the edge originates from.
     * @param _toNode The nodes the edge originates at.
     * @param _type The type of the node, either {@link ConnectionType#UNIDIRECTIONAL} or {@link ConnectionType#BIDIRECTIONAL}.
     */
    public Edge(int _fromNode, int _toNode, ConnectionType _type) throws IllegalArgumentException{
        if(_fromNode < 0 || _toNode < 0){
            throw new IllegalArgumentException("0 and below are not acceptable nodes");
        }
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